/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import so.lean.disruptor.event.CustomEvent;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: CustomEventHandler.java, v 0.1 2019-02-22 5:19 PM Exp $
 */
public class CustomEventHandler<T> implements EventHandler<CustomEvent<T>> {
    private String val;
    public CustomEventHandler(String val){
        this.val= val;
    }

    public CustomEventHandler() {

    }

    @Override
    public void onEvent(final CustomEvent<T> event, final long sequence, final boolean endOfBatch) throws Exception {
        System.out.println("消费消息EventHandler「"+val+"」，消息体："+event.getObj()+"，线程名称："
                + Thread.currentThread().getName()+Thread.currentThread().getId());
    }
}