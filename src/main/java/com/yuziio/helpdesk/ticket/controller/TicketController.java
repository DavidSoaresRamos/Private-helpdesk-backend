package com.yuziio.helpdesk.ticket.controller;

import com.yuziio.helpdesk.ticket.model.Ticket;
import com.yuziio.helpdesk.ticket.repository.TicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")  // Para teste; depois limite ao seu frontend
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) {
        try {
            // 1️⃣ Salva no MongoDB
            ticketRepository.save(ticket);
            System.out.println("Ticket salvo no MongoDB: " + ticket);

            // 2️⃣ Envia para Render API
            URL url = new URL("https://api.render.com/deploy/srv-d3dug4qli9vc73d8r810?key=EV8V33vBD8k/tickets");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(ticket);

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Ler resposta do Render
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }

            System.out.println("Resposta Render API: " + response);

            return ResponseEntity.ok("Ticket recebido e enviado para Render com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao processar ticket: " + e.getMessage());
        }
    }
}
