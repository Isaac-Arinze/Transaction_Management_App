package com.zikan.transaction_management.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

//    When a user place order he shoould get an acknowledgement
    private String orderTrackingNumber;
    private  String status;
    private String message; //display message if the transaction is successful or not

}
