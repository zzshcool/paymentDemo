package com.example.paymentDemo.controller;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.service.impl.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class PaymentController {

    @Autowired
    PayService payService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/post/form", method = RequestMethod.POST)
    public R post(@RequestBody FormBody bo) {
        log.info("-----------FormBody = {} --------------", bo);
        return payService.order(bo);
    }
}
