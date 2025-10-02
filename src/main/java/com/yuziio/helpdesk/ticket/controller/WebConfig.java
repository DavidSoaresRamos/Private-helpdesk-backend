package com.yuziio.helpdesk.ticket.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Define o caminho onde o CORS será aplicado (neste caso, todos os caminhos)
                .allowedOrigins("https://help-desk-para-chamados-ti.vercel.app/")
                .allowedOrigins("https://dashboard-helpdesk.vercel.app/requests")
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos HTTP especificados
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite que o navegador envie cookies com as requisições
    }
}

