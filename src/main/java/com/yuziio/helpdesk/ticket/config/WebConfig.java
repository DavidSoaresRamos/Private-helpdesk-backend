package com.yuziio.helpdesk.ticket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica em todos os endpoints
                .allowedOrigins(
                        "https://help-desk-para-chamados-ti.vercel.app",
                        "https://dashboard-helpdesk.vercel.app",
                        "http://localhost:4200"

                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
