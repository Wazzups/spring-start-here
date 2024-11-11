package com.wazzups.springstartherep11.proxy;

import com.wazzups.springstartherep11.models.Payment;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentsRestTemplateProxy {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    public PaymentsRestTemplateProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        String url = paymentsServiceUrl + "/payment";

        payment.setPaymentId(UUID.randomUUID().toString());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requiredId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, Payment.class).getBody();
    }
}
