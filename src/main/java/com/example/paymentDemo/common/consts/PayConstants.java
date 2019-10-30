package com.example.paymentDemo.common.consts;

import java.math.BigDecimal;

public interface PayConstants {
    /***跳转脚本*****/
    String web_eval_url = "eval_url";
    /***跳转 code_url**/
    String web_code_url = "code_url";
    /***微信公众号 js api 参数**/
    String web_payinfo = "payinfo";
    /***跳转 code_img_url**/
    String web_code_img_url = "code_img_url";
    /***跳转 qrcode_url**/
    String web_qrcode_url = "qrcode_url";
    /***跳转 跨公众号二维码支付**/
    String web_gzh_qrcode_url = "gzh_qrcode_url";
    /***跳转 form_url**/
    String web_form_url = "form_url";
    /***跳转 local_url**/
    String web_local_url = "local_url";
    /***跳转 wap_url***/
    String web_wap_url = "wap_url";
    /***确认 window******/
    String web_local_confirm = "local_confirm";
    /***确认 window******/
    String web_local_confirm_url = "local_confirm_url";

    /***提交跳转数据参数****/
    String web_jumpData = "jumpData";
    /***JUMP 跳轉 URL****/
    String web_jump_url = "order/jump";
    /***提交密文参数***/
    String web_context = "context";
    /***form提交表单***/
    String web_action = "action";
    /***form提交参数***/
    String web_params = "params";
    /***支付错误链接地址**/
    String url_pay_error = "error";
    /***支付跳转中间地址***/
    String url_pay_jump = "pay/jump";
    /***支付跳转中间绑卡***/
    String url_pay_card = "pay/card";
    /***支付跳转扫码通道界面****/
    String url_pay_qr = "pay/qr";
    /***支付宝跳转扫码通道界面****/
    String url_pay_pali = "pay/pali";
    /***支付宝跳转扫码通道界面****/
    String url_pay_mybank = "pay/mybank";
    /***支付宝跳转扫码通道界面****/
    String url_pay_aliQrcode = "pay/aliQrcode";
    /***支付跳转充值（扫码通道）****/
    String url_pay_charge = "pay/charge";
    /***支付跳转充值（扫码通道） 管理员人工充值入口****/
    String url_pay_superCharge = "pay/superCharge";
    /***支付错误链接地址**/
    String url_pay_error_frame = "pay/errorFrame";
    /***支付跳转提现*******/
    String url_pay_withdraw = "pay/withdraw";
    /***任意金额******/
    String qr_any_money_flag = "qrAnyMoneyFlag";
    /**
     * 是否为实时代付
     */
    String acp_real_time = "acpRealTime";

    /***银行卡类型***/
    String card_type = "cardType";
    /***银行卡列表  储蓄**/
    String bank_savings = "bank_savings";
    /***银行卡列表  信用***/
    String bank_credits = "bank_credits";
    /***签约详情**/
    String userSign = "userSign";
    /***签约列表**/
    String userSigns = "userSigns";
    /***银行代码描述**/
    String bankCodeDesc = "bankCodeDesc";
    /***默认商户号****/
    String pay_merchNo_default = "0";

    /**
     * 支付费率 json key
     **/
    String PAYMENT_RATE = "rate";
    String PAYMENT_UNIT = "unit";
    /**
     * 最低手续费率
     **/
    BigDecimal MIN_FEE = new BigDecimal(0.2);
}
