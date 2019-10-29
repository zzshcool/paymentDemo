package com.example.paymentDemo.service.impl;


import com.example.paymentDemo.common.enums.OrderParamKey;
import com.example.paymentDemo.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayService {


    /**
     * @param order
     * @return
     * @Description 初始化返回数据
     */
    public static Map<String, String> initRspData(Order order) {
        Map<String, String> data = new HashMap<>();
        data.put(OrderParamKey.merchNo.name(), order.getMerchNo());
        data.put(OrderParamKey.orderNo.name(), order.getOrderNo());
        data.put(OrderParamKey.outChannel.name(), order.getOutChannel());
        return data;
    }


    /**
     * @return
     * @throws Exception
     * @Description 跳转地址
     */
    public static String commonJumpUrl(Order order) throws Exception {
        String domain = order.getCallbackDomain();
        return domain;
//        RedisUtil.getSysConfigValue(CfgKeyConst.pay_jump_url) +
//                "?" + PayConstants.web_context + "=" + paramEncrypt(order.getMerchNo(), order.getOrderNo());
    }
}
