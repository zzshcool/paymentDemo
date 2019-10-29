package com.example.paymentDemo.controller;


import com.example.paymentDemo.model.FormBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class PaymentController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/post/form", method = RequestMethod.POST)
    public ModelAndView post(@RequestBody FormBody bo, Model model) {
        log.info("FormBody = {} ", bo);

        model.addAttribute("postData", bo);

        return new ModelAndView("post");
    }
}
