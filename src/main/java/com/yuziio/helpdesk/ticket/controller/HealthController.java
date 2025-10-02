package com.yuzilio.helpdesk.ticket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Combina @Controller e @ResponseBody. Perfeito para APIs REST.
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * Endpoint para checar se a aplicação Spring Boot está rodando (liveness check).
     * Retorna o status HTTP 200 (OK) e uma mensagem de texto simples.
     * Este endpoint NÃO possui injeções de dependência de repositórios (como MongoDB),
     * garantindo uma resposta instantânea e independente do estado do banco.
     */
    @GetMapping
    public ResponseEntity<String> checkHealth() {
        // Retorna o status 200 OK e o corpo da mensagem.
        return ResponseEntity.ok("Aplicação Helpdesk está OK e rodando. Liveness check.");
    }
}
