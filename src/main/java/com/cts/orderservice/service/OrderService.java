package com.cts.orderservice.service;

import com.cts.orderservice.model.ItemAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private WebClient webClient;

    public void placeOrder(int customerId, List<ItemAddress> itemAddressList) {
        // categorize items based on the shipping address state
        // send the details to the DeliveryService via ActiveMQ as individual messages
        log.info(customerId + " " + itemAddressList);
        Mono<Void> response = webClient.post()
                .uri("http://localhost:8082/packages/sort") // replace with the actual URL of the PackageService
                .bodyValue(itemAddressList)
                .retrieve()
                .bodyToMono(Void.class);
        log.info("Response: " + response);
        response.subscribe();
    }
}