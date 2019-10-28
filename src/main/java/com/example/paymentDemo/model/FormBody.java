package com.example.paymentDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
@ApiModel(value = "提交表單參數")
public class FormBody {

    @ApiModelProperty(value = "商品名稱")
    String merchantName;
    @ApiModelProperty(value = "商品圖片URL")
    String merchantImageUrl;
    @ApiModelProperty(value = "商品價格")
    BigDecimal price;
    @ApiModelProperty(value = "數量")
    Integer count;

}
