package com.example.paymentDemo.paythird.weixinPay;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.AbstractPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/***
 *
 * 微信支付
 *
 */
@Slf4j
@Service
public class WeixinPayService extends AbstractPaymentService {

    @Override
    public R order(FormBody order) {
        log.info("--------------尚未實作-------------");
        return null;
    }

    @Override
    public R query(Order order) {
        return null;
    }

    @Override
    public R notify(Order order, String requestBody) {
        return null;
    }
}
