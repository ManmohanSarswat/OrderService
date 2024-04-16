package com.cts.orderservice.controller;

import com.cts.orderservice.model.OrderRequest;
import com.cts.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest.getCustomerId(), orderRequest.getItemAddresses());
        return ResponseEntity.ok().build();
    }
}