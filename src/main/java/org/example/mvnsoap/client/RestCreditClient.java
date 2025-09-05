package org.example.mvnsoap.client;


import org.example.mvnsoap.config.RestProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.math.BigDecimal;
import java.time.Duration;

@Component
public class RestCreditClient {

    private final WebClient webClient;
    private final RestProperties props;

    public RestCreditClient(WebClient webClient, RestProperties props) {
        this.webClient = webClient;
        this.props = props;
    }

    public Mono<ScoreResponse> getScore(String requestId, String iin, String firstName, String lastName, BigDecimal amount) {
        ScoreRequest req = new ScoreRequest(requestId, iin, firstName, lastName, amount);

        return webClient.post()
                .uri("/score")
                .bodyValue(req)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), resp -> Mono.error(new RuntimeException("4xx from scoring service")))
                .onStatus(status -> status.is5xxServerError(), resp -> Mono.error(new RuntimeException("5xx from scoring service")))
                .bodyToMono(ScoreResponse.class)
                .retryWhen(Retry.backoff(props.getRetry().getAttempts(), Duration.ofMillis(props.getRetry().getInitialBackoffMs())))
                ;
    }
}
