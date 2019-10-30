package com.example.paymentDemo.paythird.linepay.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Line Pay Response Vo")
public class LienPayRspVO {

    String returnCode;
    String returnMessage;
    LinePayInfo info;
    Long transactionId;
    String paymentAccessToken;

}
