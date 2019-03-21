/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.learn.design.singleton;

/**
 * 线程安全单例写法
 * 使用volatile保证变量的可见性，禁止指令重排序优化
 * 该方式单例效率其实是很低的，因为每次调用getInstance，都必须经过synchronized排队
 *
 * tips：
 * 这种写法并不是绝对的线程安全，主要原因是volatile关键字，一个是可见性，是保证工作内存改变后写入主内存，其他线程能共享到修改结果
 * 另一个是禁止指令重排序，指令重排序是编译器优化，编译器只保证程序执行结果与源码相同。禁止指令重排序在jdk1.5以后才能正确工作
 *
 * @author ${baizhang}
 * @version $Id: SyncSingleton.java, v 0.1 2019-02-27 8:15 PM Exp $
 */
public class SyncSingleton {
    private static volatile SyncSingleton singleton= null;
    private SyncSingleton(){}
    public static SyncSingleton getInstance(){
        synchronized(SyncSingleton.class){
            if(null== singleton){
                singleton= new SyncSingleton();
            }
        }
        return singleton;
    }
}