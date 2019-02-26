/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor.factory;

import java.util.concurrent.ThreadFactory;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: DaemonThreadFactory.java, v 0.1 2019-02-25 7:38 PM Exp $
 */
public enum  DaemonThreadFactory implements ThreadFactory {
    INSTANCE;

    @Override
    public Thread newThread(final Runnable r) {
        Thread t = new Thread(r);
        t.setName("THREAD_FACTORY_");
        t.setDaemon(true);
        return t;
    }
}