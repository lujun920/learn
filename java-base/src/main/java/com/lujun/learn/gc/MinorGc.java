/*
 * Dian.so Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.lujun.learn.gc;

/**
 * TODO
 *
 * @author baizhang
 * @version: MinorGc.java, v 1.0 2020-05-14 11:03 下午 Exp $
 */
public class MinorGc {
    private static final int M= 1024* 1024;

    /*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
//       s1();
       s2();

    }

    /*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
     */
    private static void s1() {
        byte[] b1, b2, b3, b4;
        b1 = new byte[2 * M];
        b2 = new byte[2 * M];
        b3 = new byte[2 * M];
        b4 = new byte[5 * M];
    }

    /*
    对象超过设置阈值，老年代直接分配对象
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=3145728
     */
    private static void s2(){
        byte[] b1;
        b1 = new byte[7 * M];
    }
}