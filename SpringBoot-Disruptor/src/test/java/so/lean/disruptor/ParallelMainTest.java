/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import so.lean.disruptor.event.CustomEvent;
import so.lean.disruptor.event.CustomEventProducer;
import so.lean.disruptor.factory.CustomEventFactory;
import so.lean.disruptor.handler.CustomEventHandler;

import java.util.Scanner;
import java.util.concurrent.ThreadFactory;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: ParallelMainTest.java, v 0.1 2019-02-22 5:33 PM Exp $
 */
public class ParallelMainTest {


    public void start() {
        CustomEventFactory<CustomEvent<String>> eventFactory = new CustomEventFactory<CustomEvent<String>>();
        int bufferSize = 16;

        //参照 com.lmax.disruptor.util.DaemonThreadFactory，自定义线程名称
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setDaemon(true)
                .setNameFormat("consumer-queue-thread-%d").build();
        Disruptor<CustomEvent<String>> disruptor = new Disruptor(CustomEvent.FACTORY, bufferSize,
                namedThreadFactory);

        addHandler(disruptor);

        disruptor.start();

        RingBuffer<CustomEvent<String>> ringBuffer = disruptor.getRingBuffer();

//        doAfterDisruptorStart(ringBuffer);

        CustomEventProducer<String> producer = new CustomEventProducer(ringBuffer);

        for (; ; ) {
            Scanner scan = new Scanner(System.in);
            String msg = scan.nextLine();
            if ("exit".equals(msg)) {
                //通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
                disruptor.halt();
                System.exit(0);
            }
            producer.send(msg);
        }
    }
    public void addHandler(Disruptor<CustomEvent<String>> disruptor) {
        disruptor.handleEventsWith(new CustomEventHandler("step1"),
                new CustomEventHandler("step2")
                , new CustomEventHandler("step3"));
    }

    public static void main(String[] args) {
        new ParallelMainTest().start();
    }
}