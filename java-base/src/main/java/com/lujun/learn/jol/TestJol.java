/*
 * Dian.so Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.lujun.learn.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.nio.ByteOrder;

/**
 * TODO
 *
 * @author baizhang
 * @version: TestJol.java, v 1.0 2020-05-01 10:32 下午 Exp $
 */
public class TestJol {
    /**
     * 64位虚拟机中在堆内存小于32GB的情况下，UseCompressedOops是默认开启的，该参数表示开启指针压缩，会将原来64位的指针压缩为32位
     * 禁用指针压缩：-XX:-UseCompressedOops
     *
     * @param args
     */
    public static void main(String[] args) {
        Demo demo= new Demo();
        demo.setId(1123);
        demo.setName("abc");
//        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

        //打印hashcode
        System.out.println("hashCode："+demo.hashCode());
        //查看字节序
        System.out.println("byteOrder："+ByteOrder.nativeOrder());

        //打印当前jvm信息
        System.out.println("VM："+VM.current().details());
        String classLayout = ClassLayout.parseInstance(demo).toPrintable();
        System.out.println(classLayout);

    }
}