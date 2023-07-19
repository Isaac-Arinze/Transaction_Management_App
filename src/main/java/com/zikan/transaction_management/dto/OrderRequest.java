package com.zikan.transaction_management.dto;

import com.zikan.transaction_management.entity.Order;
import com.zikan.transaction_management.entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

//    We use d order request to send data from client to server in other to bind those request
    private Order order;
    private Payment payment;
}
