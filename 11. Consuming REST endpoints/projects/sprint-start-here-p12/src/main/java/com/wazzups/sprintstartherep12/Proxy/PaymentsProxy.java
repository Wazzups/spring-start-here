package com.wazzups.sprintstartherep12.Proxy;

import com.wazzups.sprintstartherep12.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

    @Value("{name.service.url}")
    private String serviceUrl;

    private final WebClient webClient;

    PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient.post().uri(serviceUrl)
            .header("request-id", requestId)
            .body(Mono.just(payment), Payment.class)
            .retrieve()
            .bodyToMono(Payment.class);
    }

}
