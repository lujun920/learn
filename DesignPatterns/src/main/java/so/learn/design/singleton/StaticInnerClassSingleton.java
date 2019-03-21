/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.design.singleton;

/**
 * 静态内部类单例
 * 缺点：
 * 1.需要额外的工作(Serializable、transient、readResolve())来实现序列化，
 * 否则每次反序列化一个序列化的对象实例时都会创建一个新的实例。
 * 2.可使用反射强行调用私有构造器
 *
 * @author ${baizhang}
 * @version $Id: StaticInnerClassSingleton.java, v 0.1 2019-02-28 9:44 AM Exp $
 */
public class StaticInnerClassSingleton {
    private static class InnerClass{
        private static StaticInnerClassSingleton singleton= new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton(){}
    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.singleton;
    }
}