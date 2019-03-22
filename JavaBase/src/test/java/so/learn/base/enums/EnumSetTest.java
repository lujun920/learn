/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.base.enums;

import java.util.EnumSet;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: EnumSetTest.java, v 0.1 2019-03-21 5:49 PM Exp $
 */
public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<ColorEnum> enumEnumSet= EnumSet.allOf(ColorEnum.class);
        for (ColorEnum e: enumEnumSet) {
            System.out.println(e.name()+"=="+e.ordinal());
        }
    }
}