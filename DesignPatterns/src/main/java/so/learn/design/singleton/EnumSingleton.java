/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.design.singleton;

/**
 * 枚举单例，推荐写法
 * 枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 *
 * @author ${baizhang}
 * @version $Id: EnumSingleton.java, v 0.1 2019-02-28 9:50 AM Exp $
 */
public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return EnumSingleton.INSTANCE;
    }
}