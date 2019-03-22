/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.base.enums;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: ColorImpl.java, v 0.1 2019-03-21 4:33 PM Exp $
 */
public enum ColorImpl implements IColor {
    RED(1, "RED", "红色"),
    GREEN(2, "GREEN", "绿色"),
    BULE(3, "BULE", "蓝色"),
    ;

    private Integer id;
    private String code;
    private String desc;

    ColorImpl(int id, String code, String desc){
        this.id= id;
        this.code= code;
        this.desc= desc;
    }
    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String desc() {
        return this.desc;
    }
}

class MainTest2 {
    public static void main(String[] args) {
        System.out.println(ColorImpl.RED.code());
    }
}