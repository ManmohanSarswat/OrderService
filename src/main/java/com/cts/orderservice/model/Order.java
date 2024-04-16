package com.cts.orderservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int customerId;
    private List<ItemAddress> itemAddresses;
}
