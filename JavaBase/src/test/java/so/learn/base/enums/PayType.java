/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.base.enums;

/**
 * 策略枚举
 *
 * @author ${baizhang}
 * @version $Id: PayType.java, v 0.1 2019-03-21 4:54 PM Exp $
 */
public enum PayType {
    ALIPAY{
        String payAmount(String amount){
            return "ALIPAY支付金额："+ amount+"元";
        }
    },
    WECHAT{
        String payAmount(String amount){
            return "WECHAT支付金额："+amount+"元";
        }
    },
    ;

    abstract String payAmount(String amount);

    String pay(String amount){
        return payAmount(amount);
    }
}

class MainTest3 {
    public static void main(String[] args) {
        System.out.println(PayType.ALIPAY.pay("10.1"));
        System.out.println(PayType.WECHAT.pay("32.1"));
    }
}