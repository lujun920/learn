/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.dian.disruptor;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: MainTest.java, v 0.1 2019-02-25 8:01 PM Exp $
 */
public class MainTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"=="+(1<< i));
        }
    }
}