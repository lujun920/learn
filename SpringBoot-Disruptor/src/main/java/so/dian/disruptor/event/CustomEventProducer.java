/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.dian.disruptor.event;

import com.lmax.disruptor.RingBuffer;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: CustomEventProducer.java, v 0.1 2019-02-22 5:53 PM Exp $
 */
public class CustomEventProducer<T> {
    private final RingBuffer<CustomEvent<T>> ringBuffer;

    public CustomEventProducer(RingBuffer<CustomEvent<T>> ringBuffer){
        this.ringBuffer= ringBuffer;
    }

    public void send(T data){
        long seq= ringBuffer.next();
        try {
            CustomEvent<T> event = ringBuffer.get(seq);
            event.setObj(data);
        }finally {
            ringBuffer.publish(seq);
        }

    }
}