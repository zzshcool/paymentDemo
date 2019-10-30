package com.example.paymentDemo.model;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Data
public class JumpData {
    Map params;
    String action;
}
