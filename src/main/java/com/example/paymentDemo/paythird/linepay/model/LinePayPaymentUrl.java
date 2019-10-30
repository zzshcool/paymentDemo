package com.example.paymentDemo.paythird.linepay.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Line pay resp paymentUrl")
public class LinePayPaymentUrl {
    String web;
    String app;
}
