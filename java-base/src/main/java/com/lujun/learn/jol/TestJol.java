/*
 * Dian.so Inc.
 * Copyright (c) 2016-2020 All Rights Reserved.
 */
package com.lujun.learn.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

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
     * 禁用pointer指针压缩：-XX:-UseCompressedClassPointers Klass Pointer关闭后为8字节
     *
     * @param args
     */
    public static void main(String[] args) {
        testObj();
//        testArrays();
//        lockObj();

    }

    private static void testObj(){
        byte[] bytes = new byte[8];
        Demo demo = new Demo();
        demo.setId(1123);
        demo.setName("abc");
        demo.setBytes(bytes);
        //查看字节序
        System.out.println("byteOrder：" + ByteOrder.nativeOrder());
        int hashCode= demo.hashCode();
        //打印hashcode
        System.out.println("hashCode：" + hashCode);
        //将hashCode转为16进制，因为打印的对象头里可以看出16进制的存储数据
        System.out.println("Hexadecimal："+ Integer.toHexString(hashCode));
        //将hashCode转为2进制，因为打印的对象头里也可以看出2进制的存储数据
        System.out.println("Binary："+Integer.toBinaryString(hashCode));

        //打印当前jvm信息
        System.out.println("VM：" + VM.current().details());
        String classLayout = ClassLayout.parseInstance(demo).toPrintable();
        System.out.println(classLayout);
    }

    private static void testArrays(){
        List<String> list = new ArrayList<>();
        list.add("1");
        //查看字节序
        System.out.println("byteOrder：" + ByteOrder.nativeOrder());
        int hashCode = list.hashCode();
        //打印hashcode
        System.out.println("hashCode：" + hashCode);
        //将hashCode转为16进制，因为打印的对象头里可以看出16进制的存储数据
        System.out.println("Hexadecimal：" +Integer.toHexString(hashCode));
        //将hashCode转为2进制，因为打印的对象头里也可以看出2进制的存储数据
        System.out.println("Binary：" +Integer.toBinaryString(hashCode));

        //打印当前jvm信息
        System.out.println("VM：" + VM.current().details());
        String classLayout = ClassLayout.parseInstance(list).toPrintable();
        System.out.println(classLayout);
    }

    private static void lockObj(){
        Object object =  new Object();
        synchronized (object){}
        //查看字节序
        System.out.println("byteOrder：" + ByteOrder.nativeOrder());
        int hashCode = object.hashCode();
        //打印hashcode
        System.out.println("hashCode：" + hashCode);
        //将hashCode转为16进制，因为打印的对象头里可以看出16进制的存储数据
        System.out.println("Hexadecimal：" + Integer.toHexString(hashCode));
        //将hashCode转为2进制，因为打印的对象头里也可以看出2进制的存储数据
        System.out.println("Binary：" + Integer.toBinaryString(hashCode));


        //打印当前jvm信息
        System.out.println("VM：" + VM.current().details());
        String classLayout = ClassLayout.parseInstance(object).toPrintable();
        System.out.println(classLayout);
    }
}