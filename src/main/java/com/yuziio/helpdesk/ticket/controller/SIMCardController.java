package com.yuziio.helpdesk.ticket.controller;
import com.yuziio.helpdesk.ticket.model.SIMCard;
import com.yuziio.helpdesk.ticket.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SIMCard")
public class SIMCardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<SIMCard> getCards() {
        return (List<SIMCard>) cardRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createCard(@RequestBody SIMCard simCard) {
        try {
            cardRepository.save(simCard);


            return ResponseEntity.ok("Resposta recebida com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar Cartão SIM " + e.getMessage());

        }
    }


}
