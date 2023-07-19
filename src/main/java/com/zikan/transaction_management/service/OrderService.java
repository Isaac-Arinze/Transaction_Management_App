package com.zikan.transaction_management.service;

import com.zikan.transaction_management.dto.OrderRequest;
import com.zikan.transaction_management.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
