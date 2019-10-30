package com.example.paymentDemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.paymentDemo.common.consts.PayConstants;
import com.example.paymentDemo.common.enums.OrderParamKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Slf4j
@Controller
public class PaymentController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/order/jump", method = RequestMethod.GET)
    public ModelAndView jump(@RequestParam(PayConstants.web_context) String context, Model model) throws UnsupportedEncodingException {
        log.info("/order/jump context = {} ", context);

        if (StringUtils.isBlank(context)) {
            return new ModelAndView(PayConstants.url_pay_error);
        }
        Base64.Decoder decoder = Base64.getDecoder();
        String jsonString = new String(decoder.decode(context), "UTF-8");

        model.addAttribute(PayConstants.web_jumpData, JSONObject.parseObject(jsonString));
        return new ModelAndView(PayConstants.url_pay_jump);
    }

}
