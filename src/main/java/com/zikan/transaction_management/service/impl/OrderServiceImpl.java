package com.zikan.transaction_management.service.impl;

import com.zikan.transaction_management.dto.OrderRequest;
import com.zikan.transaction_management.dto.OrderResponse;
import com.zikan.transaction_management.entity.Order;
import com.zikan.transaction_management.entity.Payment;
import com.zikan.transaction_management.exception.PaymentException;
import com.zikan.transaction_management.repository.OrderRepository;
import com.zikan.transaction_management.repository.PaymentRepository;
import com.zikan.transaction_management.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

//    inject order and payment repository
//    spring will automatically autowired the dependency if it finds constructor for one class

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest) {

//        Get orders and save to the database
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");

        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

//        first lest get the payment from the request object
        Payment payment = orderRequest.getPayment();

//        we supporting debit card only base on the logic below
//        if payment fails, it wont show in the databse

        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("payment card type is not supported");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment); //save payment in the database

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESSFUL");
        return orderResponse;
    }
}
