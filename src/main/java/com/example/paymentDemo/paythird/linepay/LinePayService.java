package com.example.paymentDemo.paythird.linepay;

import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.paythird.linepay.model.LienPayRspVO;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.AbstractPaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/***
 *
 * SandBox
 * ID : test_2019102824289@line.pay
 * PW : test_2019102824289
 *
 */
@Slf4j
@Service
public class LinePayService extends AbstractPaymentService {


    @Autowired
    ObjectMapper mapper;

    private String channelId = "1653321744";
    private String channelSecretKey = "220e5a486d4e720f482befd52117915d";
    private String testurl = "https://sandbox-api-pay.line.me/v2/payments/request";
    private String testImage = "https://sites.google.com/site/xiaoxiongweini333/_/rsrc/1362451027352/home/3181141_233425002_2.jpg?height=846&width=262";
    private String requestUri = "/v3/payments/request";

    @Override
    public R order(FormBody order) {
        log.info("Lne Pay  開始------------------------------------------------------");

        ResponseEntity<LienPayRspVO> rsp = null;
        Map<String, Object> formData = new HashMap<>();
        formData.put(LinePayConst.amount, order.getPrice().toBigInteger());
        formData.put(LinePayConst.currency, "TWD");
        formData.put(LinePayConst.orderId, order.getOrderNo());
        formData.put(LinePayConst.productImageUrl, order.getProductImageUrl());
        formData.put(LinePayConst.confirmUrl, order.getConfirmUrl());
        formData.put(LinePayConst.productName, order.getProductName());


        String nonce = UUID.randomUUID().toString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("X-LINE-ChannelId", channelId);
        headers.add("X-LINE-ChannelSecret", channelSecretKey);
        headers.add("X-LINE-Authorization-Nonce", nonce);
        headers.add("X-LINE-Authorization", HmacSignatureUtil.encrypt(channelSecretKey, channelSecretKey + requestUri + JSONObject.fromObject(formData).toString() + nonce));
        log.info("headers = {} ", headers.toString());
        log.info("JsonData = {} ", JSONObject.fromObject(formData).toString());
        HttpEntity<String> request = new HttpEntity<String>(JSONObject.fromObject(formData).toString(), headers);

        RestTemplate restTemplate = new RestTemplate();

        log.info("Line Pay  結束------------------------------------------------------");
        rsp = restTemplate.postForEntity(testurl, request, LienPayRspVO.class);
        log.info(" rsp = {} ", rsp);
        return R.okData(rsp.getBody().getInfo().getPaymentUrl());
    }

    @Override
    public R query(Order order) {
        return null;
    }

    @Override
    public R notify(Order order, String requestBody) {
        return null;
    }

//    public static void main(String[] args) {
//        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//
//        Order order = new Order();
//        order.setOrderNo(reqTime + new Random().nextInt(100000));
//        order.setAmount(new BigDecimal(new Random().nextInt(1000)));
//        order.setReqTime(reqTime);
//        order.setReturnUrl("http://www.google.com");
//        order.setNotifyUrl("http://www.google.com");
//
//        LinePayService service = new LinePayService();
//        R r = service.order(order);
//        log.info(" R = {} ", r);
//    }
}
