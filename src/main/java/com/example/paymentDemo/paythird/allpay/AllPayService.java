package com.example.paymentDemo.paythird.allpay;

import com.example.paymentDemo.common.R;
import com.example.paymentDemo.model.FormBody;
import com.example.paymentDemo.model.Order;
import com.example.paymentDemo.paythird.AbstractPaymentService;
import com.example.paymentDemo.paythird.ecpay.ECPayConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class AllPayService extends AbstractPaymentService {

    /**
     * 歐付寶測試參數
     **/
    private String MerchantID = "2000132";
    private String hashKey = "5294y06JbISpM5x9";
    private String hashIV = "v77hoKGq4kWxNNIS";
    private String paymentType = "aio";
    private String choosePayment = "ALL";
    private String checkMacValue = "1";
    private String testAllPayURL = "https://payment-stage.opay.tw/Cashier/AioCheckOut/V5";

    @Override
    public R order(FormBody order) {
        Map<String, String> resultMap = null;
        log.info("歐付寶支付 開始------------------------------------------------------");
        Map<String, String> formData = new HashMap<>();
        formData.put(ECPayConst.MerchantID, MerchantID);
//        formData.put(ECPayConst.MerchantTradeNo, order.getOrderNo());
        formData.put(ECPayConst.MerchantTradeDate, ECPayConst.DateFormatter.print(System.currentTimeMillis()));
        formData.put(ECPayConst.TotalAmount, ECPayConst.AmountFormatter.format(order.getPrice()));
        formData.put(ECPayConst.PaymentType, paymentType);
        formData.put(ECPayConst.ChoosePayment, choosePayment);
//        formData.put(ECPayConst.ItemName, order.getOrderNo());
//        formData.put(ECPayConst.TradeDesc, order.getOrderNo());
        formData.put(ECPayConst.ReturnURL, order.getConfirmUrl());
        formData.put(ECPayConst.EncryptType, checkMacValue);
        formData.put(ECPayConst.CheckMacValue, this.buildSign(formData, hashKey, hashIV));
        log.info("歐付寶支付 結束------------------------------------------------------");
        return R.okData(this.createJumpResultMap(order, formData, testAllPayURL));
    }


    @Override
    public R query(Order order) {
        return null;
    }

    @Override
    public R notify(Order order, String requestBody) {
        return null;
    }
}
