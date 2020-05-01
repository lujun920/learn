/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.base.enums;

/**
 * 枚举、枚举方法
 *
 * @author ${baizhang}
 * @version $Id: ColorEnum.java, v 0.1 2019-03-21 3:59 PM Exp $
 */
public enum ColorEnum {
    RED, ORANGE, YELLOW, GREEN, BLUE,;
}

/**
 * values()：返回 enum 实例的数组，而且该数组中的元素严格保持在 enum 中声明时的顺序。
 * name()：返回实例名。
 * ordinal()：返回实例声明时的次序，从 0 开始。
 * getDeclaringClass()：返回实例所属的 enum 类型。
 * equals() ：判断是否为同一个对象。
 *
 * output:
 * RED==RED==0
 * ORANGE==ORANGE==1
 * YELLOW==YELLOW==2
 * GREEN==GREEN==3
 * BLUE==BLUE==4
 * ====================
 * RED
 * 0
 * class so.learn.base.enums.ColorEnum
 * ORANGE
 * 1
 * class so.learn.base.enums.ColorEnum
 * ====================
 * false
 * true
 * false
 */
class MainTest1 {
    public static void main(String[] args) {
        for (ColorEnum e: ColorEnum.values()) {
            System.out.println(e+"=="+e.name()+"=="+e.ordinal());
        }
        System.out.println("====================");
        System.out.println(ColorEnum.RED.name());
        System.out.println(ColorEnum.RED.ordinal());
        System.out.println(ColorEnum.RED.getDeclaringClass());


        System.out.println(ColorEnum.ORANGE.name());
        System.out.println(ColorEnum.ORANGE.ordinal());
        System.out.println(ColorEnum.ORANGE.getDeclaringClass());

        System.out.println("====================");
        System.out.println(ColorEnum.RED.equals(ColorEnum.ORANGE));
        System.out.println(ColorEnum.RED.equals(ColorEnum.RED));
        System.out.println(ColorEnum.RED.equals(0));
        System.out.println(ColorEnum.RED==ColorEnum.ORANGE);
    }
}