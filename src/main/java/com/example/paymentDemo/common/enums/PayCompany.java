package com.example.paymentDemo.common.enums;

import lombok.Getter;

public enum PayCompany {

    linepay("linepay", "Line Pay"),
    ecpay("ecpay", "綠界支付"),
    alipay("alipay", "支付寶"),
    allpay("allpay", "歐付寶");

    @Getter
    public String value;
    @Getter
    public String description;

    PayCompany(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
