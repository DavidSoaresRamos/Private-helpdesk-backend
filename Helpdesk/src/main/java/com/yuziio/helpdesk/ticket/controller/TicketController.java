package com.yuziio.helpdesk.ticket.controller;

import com.yuziio.helpdesk.ticket.model.Ticket;
import com.yuziio.helpdesk.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController /* Permite a classe responder a requisições HTTP */
@RequestMapping("/tickets") /* Define uma rota */
@CrossOrigin(origins = "*")  /* Permite qualquer frontend se conectar com esse backend */ /** MUDAR QUANDO HOSPEDAR O BACKEND*/

public class TicketController {


    @Autowired
    private TicketRepository ticketRepository; /* Responsavel por salvar os dados no banco de dados */


    @GetMapping
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) { /* Converte o JSON para um objeto Ticket */
        try {
            ticketRepository.save(ticket); /* Salva o objeto Ticket que foi convertido no banco de dados */
            System.out.println("Ticket salvo no MongoDB: " + ticket); /* log de confirmação */
            return ResponseEntity.ok("Ticket recebido com sucesso!"); /* Resposta HTTP 200 em caso de sucesso no envio */
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao salvar ticket: " + e.getMessage());/* Reposta em caso de erro no envio*/

        }
    }
}