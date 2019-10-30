package com.example.paymentDemo.model;

import com.example.paymentDemo.common.enums.PayCompany;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Data
@ApiModel(value = "提交表單參數")
public class FormBody {

    @ApiModelProperty(value = "商品名稱")
    String productName;
    @ApiModelProperty(value = "商品圖片URL")
    String productImageUrl;
    @ApiModelProperty(value = "商品價格")
    BigDecimal price;
    @ApiModelProperty(value = "數量")
    Integer count;
    @ApiModelProperty(value = "幣別")
    String currency;
    @ApiModelProperty(value = "Notify Url")
    String confirmUrl;
    @ApiModelProperty(value = "支付公司代號")
    PayCompany payCompany;
    @ApiModelProperty(value = "跳转结果")
    Map<String, Object> jumpData = new HashMap<>();


    String orderNo;
    String merchNo;
}

