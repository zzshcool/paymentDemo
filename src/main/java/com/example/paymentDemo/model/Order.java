package com.example.paymentDemo.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Data
@ApiModel(value = "訂單資訊")
public class Order {
    /**
     * 商户号
     */
    private String merchNo;
    private String merchName;
    /**
     * 订单号 由发起支付方提供 在该商户号下保证唯一
     */
    private String orderNo;
    /***
     * 渠道编码 微信WAP支付：wap 微信公众号支付：gzh 微信扫码：wx QQ钱包扫码：qq
     *               支付宝扫码：ali 快捷支付：q 网银支付：wy 代付：acp
     */
    private String outChannel;
    /***
     * 标题20个字符以内
     */
    private String title;

    /***
     * 产品描述 20个字符以内
     */
    private String product;
    /**
     * 金额(单位元) 币种 人民币 两位小数
     */
    private BigDecimal amount;
    /**
     * 币种 CNY
     */
    private String currency;
    /***
     * 订单状态
     */
    private Integer orderState;
    /***
     * 前端返回地址
     */
    private String returnUrl;
    /***
     * 后台通知地址
     */
    private String notifyUrl;
    /***
     * 请求时间 格式 yyyyMMddHHmmss
     */
    private String reqTime;
    /***
     * 请求ip
     */
    private String reqIp;
    /**
     * 支付用户
     */
    private String userId;
    /***
     * 备注
     */
    private String memo;

    //*************************代付
    /**
     * 持卡用户名
     */
    private String acctName;
    /****
     * 持卡身份证号码
     */
    private String certNo;
    /***
     * 身份证类型
     */
    private Integer certType;
    /***
     *
     * 银行卡号
     */
    private String bankNo;
    /***
     * 手机号
     */
    private String mobile;
    /**
     * 银行代码
     */
    private String bankCode;
    /**
     * 银行名称
     */
    private String bankName;
    /****
     * 卡号类型
     */
    private Integer cardType;
    /**
     * 账户性质
     */
    private Integer acctType;
    /**
     * 银行行号
     */
    private String unionpayNo;
    /**
     * 支行
     */
    private String bankBranch;

    private String bankCity;

    private String bankProvince;
    //提现字段
    private Integer city;
    private Integer province;

    //*****************third
    /***支付公司协议号**/
    private String sign;
    /***支付公司***/
    private String payCompany;
    /***支付商户号***/
    private String payMerch;
    /***第三方支付订单号***/
    private String businessNo;
    /***回调支付金额*/
    private BigDecimal realAmount;
    /***回调提示消息***/
    private String msg;
    /***支付中间结果**/
    private Map<String, String> resultMap = new HashMap<>();
    /***跳转结果***/
    private Map<String, Object> jumpData = new HashMap<>();
    /***签约信息****/
    //private MerchUserSignDO userSign;
    /***快捷确认支付验证码****/
    private String checkCode;
    /**
     * 回调域名
     **/
    private String callbackDomain;
    //************持久化数据
    /***创建时间***/
    private int crtDate;
    //成本金额
    private BigDecimal costAmount;
    //商户金额
    private BigDecimal qhAmount;
    //代理金额
    private BigDecimal agentAmount;
    //上级代理金额
    private BigDecimal subAgentAmount;
    //清算状态
    private Integer clearState;
    //已清算金额
    private BigDecimal clearAmount;
    //订单类型
    private Integer orderType;
    //结算方式
    private Integer paymentMethod;
    //用户类型
    private Integer userType;

    //通知状态
    private Integer noticeState;
    /***
     * 最近一次锁住时间
     */
    private Integer lastLockTime;

    //记录
    //本次清算金额
    private BigDecimal clearAmountThe;
}
