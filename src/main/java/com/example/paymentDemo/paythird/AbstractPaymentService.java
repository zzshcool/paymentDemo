package com.example.paymentDemo.paythird;

import com.alibaba.fastjson.JSONObject;
import com.example.paymentDemo.common.R;
import com.example.paymentDemo.common.consts.PayConstants;
import com.example.paymentDemo.common.util.MD5Util;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.model.JumpData;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.ecpay.ECPayConst;
import com.example.paymentDemo.paythird.ecpay.SHAUtil;
import com.example.paymentDemo.service.impl.PayService;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


@Slf4j
public abstract class AbstractPaymentService {

    public abstract R order(FormBody order);

    public abstract R query(Order order);

    /**
     * @param order
     * @param requestBody
     * @return
     * @Description bopay 回调处理
     */
    public abstract R notify(Order order, String requestBody);

    public String createSignString(Map<String, String> formData, String key) {
        StringBuilder sb = new StringBuilder();
        TreeSet<String> sort = new TreeSet<String>(formData.keySet());
        sort.forEach(s -> sb.append(s + "=" + formData.get(s) + "&"));
        sb.append(key);
        return sb.toString();
    }

    public String createSignJustAppend(Map<String, String> formData, String key) {
        StringBuilder sb = new StringBuilder();
        TreeSet<String> sort = new TreeSet<String>(formData.keySet());
        sort.forEach(s -> sb.append(formData.get(s)));
        try {
            return MD5Util.digestString(sb.toString(), key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String buildSign(Map<String, String> formData, String testHashKey, String testHashIV) {
        StringBuilder sb = new StringBuilder(ECPayConst.HashKey + "=" + testHashKey + "&");
        TreeSet<String> sort = new TreeSet<String>(formData.keySet());
        sort.forEach(s -> sb.append(s + "=" + formData.get(s) + "&"));
        sb.append(ECPayConst.HashIV + "=" + testHashIV);
        log.info(" sb = {} ", sb);
        try {
            return SHAUtil.digestSHA256(URLEncoder.encode(sb.toString(), "UTF-8").toLowerCase()).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> createJumpResultMap(FormBody order, Map<String, String> formData, String url) {
        Map<String, String> resultMap = PayService.initRspData(order);
        try {
            resultMap.put(PayConstants.web_code_url, PayService.commonJumpUrl(order));
        } catch (Exception e) {
            log.error("jump加密异常！！");
        }
        // order.setResultMap(resultMap);
        Map<String, Object> jumpData = new HashMap<>();
        jumpData.put(PayConstants.web_params, formData);
        jumpData.put(PayConstants.web_form_url, 1);
        jumpData.put(PayConstants.web_action, url);
        order.setJumpData(jumpData);
        return resultMap;
    }

    public String createJumpResultJSONString(Map<String, String> formData, String postUrl) {
        JumpData jumpData = new JumpData();
        jumpData.setAction(postUrl);
        jumpData.setParams(formData);
        Base64.Encoder encoder = Base64.getEncoder();
        return PayConstants.web_jump_url + "?" + PayConstants.web_context + "=" + encoder.encodeToString(JSONObject.toJSONString(jumpData).getBytes());
    }


}
