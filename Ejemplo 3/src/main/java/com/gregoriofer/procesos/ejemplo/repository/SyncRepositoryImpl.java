package com.gregoriofer.procesos.ejemplo.repository;

import com.gregoriofer.procesos.ejemplo.dto.PeticionDeSumaSencilla;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class SyncRepositoryImpl implements SyncRepository {

    public Integer sumaSincrona(final Integer operador1, final Integer operador2) {
        final HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(5));
        final WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(client)).build();
        return webClient.get()
                .uri("http://localhost:8082/sync/suma?operador1=" + operador1 + "&operador2=" + operador2)
                .retrieve().bodyToMono(Integer.class).timeout(Duration.ofSeconds(5)).block();
    }

    @Override
    public List<Integer> sumaSincronaMultiple(final List<PeticionDeSumaSencilla> operaciones) throws Exception {
        final HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(5));
        final WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(client)).build();

        try {
            final List<Integer> resultados = new ArrayList<>();

            for (int i = 0; i < operaciones.size(); i++) {
                //
            }

            for (final PeticionDeSumaSencilla operacion : operaciones) {
                resultados.add(webClient.get()
                        .uri("http://localhost:8082/sync/suma?operador1=" + operacion.getOperador1() + "&operador2="
                                + operacion.getOperador2()).retrieve().bodyToMono(Integer.class)
                        .timeout(Duration.ofSeconds(5)).block());
            }

            operaciones.forEach(operacion ->
                    resultados.add(webClient.get()
                            .uri("http://localhost:8082/sync/suma?operador1=" + operacion.getOperador1() + "&operador2="
                                    + operacion.getOperador2()).retrieve().bodyToMono(Integer.class)
                            .timeout(Duration.ofSeconds(5)).block())
            );

            //baeldung
            //streams
            final List<PeticionDeSumaSencilla> operacionesConOperador1A1 =
                    operaciones.stream().filter(operacion -> operacion.getOperador1() == 1)
                            .collect(Collectors.toList());

            final List<Integer> resultados1 = operaciones.stream().map(operacion -> {
                return operacion.getOperador1() + operacion.getOperador2();
            }).filter(resultado -> resultado > 100).collect(Collectors.toList());

            return resultados;
        } catch (final Exception exception) {
            throw new Exception("Error con los campos indicados.");
        }
    }

    public void sumaAsincrona(final Integer operador1, final Integer operador2) {
        final WebClient webClient = WebClient.builder().build();
        webClient.get()
                .uri("http://localhost:8082/sync/suma?operador1=" + operador1 + "&operador2=" + operador2)
                .retrieve().bodyToMono(Integer.class).subscribe(result -> log.info("Resultado de la suma: {}", result));
    }
}
