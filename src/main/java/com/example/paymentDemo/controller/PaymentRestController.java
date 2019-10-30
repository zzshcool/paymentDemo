package com.example.paymentDemo.controller;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.service.impl.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentRestController {

    @Autowired
    PayService payService;

    @RequestMapping(value = "/post/form", method = RequestMethod.POST)
    public R post(@RequestBody FormBody bo) {
        log.info("-----------FormBody = {} --------------", bo);
        return payService.order(bo);
    }
}
