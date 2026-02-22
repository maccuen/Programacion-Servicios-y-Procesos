package com.gregoriofer.procesos.ejemplo.repository;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Repository
public class SyncRepositoryImpl implements SyncRepository {

    public Integer suma(final Integer operador1, final Integer operador2) {
        final HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(5));
        final WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(client))
                .build();
        return webClient.get().uri(
                        "http://localhost:8082/sync/suma?operador1=" + operador1 + "&operador2=" + operador2)
                .retrieve().bodyToMono(Integer.class).timeout(Duration.ofSeconds(5)).block();
    }
}