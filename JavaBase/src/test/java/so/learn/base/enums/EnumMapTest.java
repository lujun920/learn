/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.base.enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: EnumMapTest.java, v 0.1 2019-03-21 7:13 PM Exp $
 */
public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<ColorEnum, String> colorEnumStringEnumMap = new EnumMap(ColorEnum.class);
        colorEnumStringEnumMap.put(ColorEnum.RED, "红色");
        colorEnumStringEnumMap.put(ColorEnum.YELLOW, "黄色");
        colorEnumStringEnumMap.put(ColorEnum.BLUE, "蓝色");

        for (Iterator<Map.Entry<ColorEnum, String>> iter = colorEnumStringEnumMap.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<ColorEnum, String> entry = iter.next();
            System.out.println(entry.getKey().name() + " : " + entry.getValue());
        }
    }
}