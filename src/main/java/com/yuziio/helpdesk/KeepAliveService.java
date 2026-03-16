package com.yuziio.helpdesk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port:8080}")
    private int port;

    @Scheduled(fixedRate = 300000) 
    public void keepAlive() {
        try {
            String url = "http://localhost:" + port + "/actuator/health";
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Keep-alive ping successful: " + response);
        } catch (Exception e) {
            System.err.println("Keep-alive ping failed: " + e.getMessage());
        }
    }
}
