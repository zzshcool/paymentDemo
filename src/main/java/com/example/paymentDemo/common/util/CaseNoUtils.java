package com.example.paymentDemo.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CaseNoUtils {

    private static String orderIdPrefix = "Z";

    public static String genOrderNo() {
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return orderIdPrefix + reqTime + new Random().nextInt(100000);
    }
}
