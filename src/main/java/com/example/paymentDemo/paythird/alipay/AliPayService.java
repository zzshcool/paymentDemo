package com.example.paymentDemo.paythird.alipay;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.AbstractPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AliPayService extends AbstractPaymentService {
    @Override
    public R order(FormBody order) {
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
