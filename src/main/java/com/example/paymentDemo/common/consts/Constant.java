package com.example.paymentDemo.common.consts;

public interface Constant {

    /***支付公司名称*****/
    String pay_name = "Payment Center";
    /*** 返回码定义 *****/
    String result_code = "code";
    /*** 返回消息 **/
    String result_msg = "msg";
    /*** 返回成功值：0 ******/
    int result_code_succ = 0;
    /*** 返回失败值：1 *****/
    int result_code_error = 1;
    /*** 返回成功信息 success ***/
    String result_msg_succ = "success";
    String result_msg_succ_ = "result=success";
    /*** 返回成功信息 ok***/
    String result_msg_ok = "ok";
    String result_msg_ok_ = "result=ok";
    /*** 返回成功信息 error ***/
    String result_msg_error = "error";
    /*** 返回数据 data ****/
    String result_data = "data";
    /***系统编码 UTF-8****/
    String ec_utf_8 = "UTF-8";
    /***系统编码 GBK****/
    String ec_gbk = "GBK";
    int data_exist = 2;
    int data_noexist = 3;
    /***商户信息参数 merch*****/
    String param_merch = "merch";
    /***json数据参数 jsonData*****/
    String param_jsonData = "jsonData";
    /***任务--参数***/
    String task_params = "params";
    /***任务--动态选择时间**/
    String task_choiceDate = "choiceDate";
}
