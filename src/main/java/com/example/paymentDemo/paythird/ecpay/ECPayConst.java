package com.example.paymentDemo.paythird.ecpay;


import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DecimalFormat;

public interface ECPayConst {
    /**
     * 日期格式
     */
    DateTimeFormatter DateFormatter = DateTimeFormat.forPattern("YYYY/MM/dd HH:mm:ss");
    /**
     * 金額格式
     */
    DecimalFormat AmountFormatter = new DecimalFormat("0");
    /**
     * 合作特店編號
     */
    String MerchantID = "MerchantID";
    /**
     * 合作特店交易編號
     */
    String MerchantTradeNo = "MerchantTradeNo";
    String MerchantTradeDate = "MerchantTradeDate";
    String ClientBackURL = "ClientBackURL";
    String ReturnURL = "ReturnURL";
    String OrderResultURL = "OrderResultURL";
    /**
     * 檢查碼
     */
    String CheckMacValue = "CheckMacValue";
    String HoldTradeAMT = "HoldTradeAMT";
    String PlatformID = "PlatformID";
    String HashKey = "HashKey";
    String HashIV = "HashIV";
    String EncryptType = "EncryptType";
    /**
     * 合作特店 選擇的付款方式
     */
    String PaymentType = "PaymentType";
    String ExpireDate = "ExpireDate";
    String StoreExpireDate = "StoreExpireDate";
    /**
     * 付款時間 格式為 yyyy/MM/dd HH:mm:ss
     */
    String PaymentDate = "PaymentDate";
    /**
     * 通路費
     */
    String PaymentTypeChargeFee = "PaymentTypeChargeFee";
    String TradeStatus = "TradeStatus";
    /**
     * 綠界的交易編號 請保存綠界的交易編號與合作特店 交易編號[MerchantTradeNo]的關連。
     */
    String TradeNo = "TradeNo";
    /**
     * 交易金額
     */
    String TradeAmt = "TradeAmt";
    String IgnorePayment = "IgnorePayment";
    /**
     * 交易狀態 若回傳值為 1 時，為付款成功 其餘代碼皆為交易失敗，請勿出貨
     */
    String RtnCode = "RtnCode";
    /**
     * 交易訊息
     */
    String RtnMsg = "RtnMsg";
    /**
     * 訂單成立時間 格式為 yyyy/MM/dd HH:mm:ss
     */
    String TradeDate = "TradeDate";
    /**
     * 是否為模擬付款回傳值：若為 1 時，代表此交易為模擬付款，請勿出貨。若為 0 時，代表此交易非模擬付款。
     */
    String SimulatePaid = "SimulatePaid";
    String CustomField1 = "CustomField1";
    String CustomField2 = "CustomField2";
    String CustomField3 = "CustomField3";
    String CustomField4 = "CustomField4";
    /**
     * 合作特店商店代碼 此功能尚未開啟
     */
    String StoreID = "StoreID";
    String TimeStamp = "TimeStamp";
    String TotalAmount = "TotalAmount";
    String TradeDesc = "TradeDesc";
    String ItemName = "ItemName";
    String Remark = "Remark";
    String ChoosePayment = "ChoosePayment";
    String ChooseSubPayment = "ChooseSubPayment";
    String NeedExtraPaidInfo = "NeedExtraPaidInfo";
    String InvoiceMark = "InvoiceMark";

}
