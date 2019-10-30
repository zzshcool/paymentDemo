package com.example.paymentDemo.paythird.ecpay;


import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.AbstractPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class ECPayService extends AbstractPaymentService {


    /**
     * ECPay Test Key & Merchant
     **/
    private String testMerchantNO = "2000132";
    private String testHashKey = "5294y06JbISpM5x9";
    private String testHashIV = "v77hoKGq4kWxNNIS";
    private String testECPayURL = "https://payment-stage.ecpay.com.tw/Cashier/AioCheckOut/V5";

    private String paymentType = "aio";
    // 快捷開啟支付類型設定 ALL 全開
    private String choosePayment = "ALL";
    // 是否需要額外訊息
    private final String NeedExtraPaidInfo = "N";
    private final String ENC_SHA256 = "1";

    /**
     * @param order
     * @return
     * @Description 發起綠界支付
     */

    @Override
    public R order(FormBody order) {
        Map<String, String> formData = new HashMap<>();
        try {
            log.info("綠界支付 開始------------------------------------------------------");
            formData.put(ECPayConst.MerchantID, testMerchantNO);
            formData.put(ECPayConst.MerchantTradeNo, order.getOrderNo());
            formData.put(ECPayConst.MerchantTradeDate, ECPayConst.DateFormatter.print(System.currentTimeMillis()));
            formData.put(ECPayConst.TotalAmount, ECPayConst.AmountFormatter.format(order.getPrice()));
            formData.put(ECPayConst.PaymentType, paymentType);
            formData.put(ECPayConst.NeedExtraPaidInfo, NeedExtraPaidInfo);
            formData.put(ECPayConst.ChoosePayment, choosePayment);
            formData.put(ECPayConst.EncryptType, ENC_SHA256);
            formData.put(ECPayConst.ItemName, order.getOrderNo());
            formData.put(ECPayConst.TradeDesc, order.getOrderNo());
            formData.put(ECPayConst.ReturnURL, order.getConfirmUrl());
            formData.put(ECPayConst.CheckMacValue, this.buildSign(formData, testHashKey, testHashIV));
            log.info(" formData = {} ", formData);


//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(convertMultiValueMap(formData), headers);
//
//            RestTemplate restTemplate = new RestTemplate();
//            rsp = restTemplate.postForEntity(testECPayURL, request, String.class);
        } catch (Exception e) {
            log.error("ECPayService order Error", e);
        }
        //log.info("rsp = {} ", rsp.toString());
        log.info("綠界支付 结束------------------------------------------------------");
        log.info("jump data = {} ", this.createJumpResultJSONString(formData, testECPayURL));
        return R.okData(this.createJumpResultJSONString(formData, testECPayURL));
    }

    /**
     * 查詢訂單狀態
     *
     * @param order
     */
    @Override
    public R query(Order order) {
        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put(ECPayConst.MerchantID, testMerchantNO);
        requestMap.put(ECPayConst.MerchantTradeNo, order.getOrderNo());
        requestMap.put(ECPayConst.TimeStamp, String.valueOf(System.currentTimeMillis() / 1000));
        requestMap.put(ECPayConst.PlatformID, "");


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
//
//        ECPayService service = new ECPayService();
//        R r = service.order(order);
//        log.info(" R = {} ", r);
//    }
}
