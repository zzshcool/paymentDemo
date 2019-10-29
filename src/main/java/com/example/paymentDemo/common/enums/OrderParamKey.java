package com.example.paymentDemo.common.enums;

import lombok.Getter;

public enum OrderParamKey {


    merchNo("merchNo", "商戶號"),
    orderNo("orderNo", "定單號由發起方提供"),
    outChannel("outChannel", "渠道编码");

    @Getter
    public String value;
    @Getter
    public String description;


    OrderParamKey(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
