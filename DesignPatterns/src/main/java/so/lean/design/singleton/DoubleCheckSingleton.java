/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.design.singleton;

/**
 * 双重检查，在同步锁的基础上在进行一次判断检查提升性能
 *
 * @author ${baizhang}
 * @version $Id: DoubleCheckSingleton.java, v 0.1 2019-02-27 8:31 PM Exp $
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton= null;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getInstance(){
        if(null== singleton){
            synchronized (DoubleCheckSingleton.class){
                if(null== singleton){
                    singleton= new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}