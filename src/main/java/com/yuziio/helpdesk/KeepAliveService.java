package com.yuziio.helpdesk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveService {

    private final RestTemplate restTemplate;

    public KeepAliveService() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(2000);
        requestFactory.setReadTimeout(2000);
        this.restTemplate = new RestTemplate(requestFactory);
    }

    @Value("${server.port:8080}")
    private int port;

    @Value("${RENDER_EXTERNAL_URL:}")
    private String renderExternalUrl;

    @Value("${keepalive.url:}")
    private String keepAliveUrl;

    @Scheduled(fixedRate = 300000, initialDelay = 60000) // 5 min (300000ms), começa após 1 min
    public void keepAlive() {
        try {
            String baseUrl = resolveBaseUrl();
            String url = baseUrl + "/actuator/health";
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Keep-alive ping successful (" + url + "): " + response);
        } catch (Exception e) {
            System.err.println("Keep-alive ping failed: " + e.getMessage());
        }
    }

    private String resolveBaseUrl() {
        if (keepAliveUrl != null && !keepAliveUrl.isBlank()) {
            return normalizeUrl(keepAliveUrl);
        }

        if (renderExternalUrl != null && !renderExternalUrl.isBlank()) {
            return normalizeUrl(renderExternalUrl);
        }

        return "http://localhost:" + port;
    }

    private String normalizeUrl(String rawUrl) {
        String url = rawUrl.trim();
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }
        return url.replaceAll("/+$", "");
    }
}


