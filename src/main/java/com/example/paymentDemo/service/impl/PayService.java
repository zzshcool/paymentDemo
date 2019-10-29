package com.example.paymentDemo.service.impl;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.common.enums.OrderParamKey;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.paythird.allpay.AllPayService;
import com.example.paymentDemo.paythird.ecpay.ECPayService;
import com.example.paymentDemo.paythird.linepay.LinePayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PayService {

    @Autowired
    AllPayService allPayService;
    @Autowired
    LinePayService linePayService;
    @Autowired
    ECPayService ecPayService;

    /**
     * @param order
     * @return
     * @Description 初始化返回数据
     */
    public static Map<String, String> initRspData(FormBody order) {
        Map<String, String> data = new HashMap<>();
        data.put(OrderParamKey.merchNo.name(), order.getMerchNo());
        data.put(OrderParamKey.orderNo.name(), order.getOrderNo());
        data.put(OrderParamKey.outChannel.name(), order.getPayCompany().value);
        return data;
    }


    /**
     * @return
     * @throws Exception
     * @Description 跳转地址
     */
    public static String commonJumpUrl(FormBody order) throws Exception {
        String domain = order.getConfirmUrl();
        return domain;
//        RedisUtil.getSysConfigValue(CfgKeyConst.pay_jump_url) +
//                "?" + PayConstants.web_context + "=" + paramEncrypt(order.getMerchNo(), order.getOrderNo());
    }

    public R order(FormBody bo) {
        if (null == bo || null == bo.getPayCompany()) {
            return R.error("未找到支付公司！");
        }

        switch (bo.getPayCompany()) {
            case ecpay:
                return ecPayService.order(bo);
            case allpay:
                return allPayService.order(bo);
            case linepay:
                return linePayService.order(bo);
            default:
                log.error("未找到支付公司！");
                return R.error("未找到支付公司！");
        }
    }
}
