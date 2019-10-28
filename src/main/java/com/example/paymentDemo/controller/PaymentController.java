package com.example.paymentDemo.controller;


import com.example.paymentDemo.model.FormBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @PostMapping("/post/form")
    public ModelAndView post(@RequestBody FormBody bo, Model model) {

        model.addAttribute("postData", bo);

        return new ModelAndView("post");
    }
}
