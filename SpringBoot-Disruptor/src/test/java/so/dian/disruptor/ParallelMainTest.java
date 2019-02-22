/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.dian.disruptor;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import so.dian.disruptor.event.CustomEvent;
import so.dian.disruptor.event.CustomEventProducer;
import so.dian.disruptor.factory.CustomEventFactory;
import so.dian.disruptor.handler.CustomEventHandler;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: ParallelMainTest.java, v 0.1 2019-02-22 5:33 PM Exp $
 */
public class ParallelMainTest {

    /**
     * 创建线程池
     * 当前属于IO型操作，核心线程可以适当设置大一些
     * 线程池大小：cpu核心数 * 5 + 1
     * 线程池队列最大值：500
     * 队列：LinkedBlockingDeque
     * 策略：AbortPolicy
     */
    private ExecutorService pool = new ThreadPoolExecutor(
            2,
            500,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(1024),
            r -> new Thread(r, "TEST_POOL_"),
            new ThreadPoolExecutor.AbortPolicy());
    private ListeningExecutorService executorService = MoreExecutors.listeningDecorator(pool);

    public void run(){
        int bufferSize= 1024;
        CustomEventFactory<CustomEvent<String>> eventFactory= new CustomEventFactory();


        /*
         * createSingleProducer创建一个单生产者的RingBuffer，
         * 第一个参数叫EventFactory，从名字上理解就是“事件工厂”，其实它的职责就是产生数据填充RingBuffer的区块。
         * 第二个参数是RingBuffer的大小，它必须是2的指数倍 目的是为了将求模运算转为&运算提高效率
         * 第三个参数是RingBuffer的生产都在没有可用区块的时候(可能是消费者（或者说是事件处理器） 太慢了)的等待策略
         */
        final RingBuffer<CustomEvent<String>> ringBuffer =
                RingBuffer.createSingleProducer((EventFactory<CustomEvent<String>>) () ->
                        new CustomEvent(), bufferSize, new YieldingWaitStrategy());

//        //创建SequenceBarrier
//        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

//        //创建消息处理器
//        BatchEventProcessor<CustomEvent<String>> transProcessor = new BatchEventProcessor<CustomEvent<String>>(
//                ringBuffer, sequenceBarrier, new CustomEventHandler());


        Disruptor<CustomEvent<String>> disruptor = new Disruptor(eventFactory, bufferSize,
                executorService);

        addHandler(disruptor);

        disruptor.start();

//        //这一部的目的是让RingBuffer根据消费者的状态    如果只有一个消费者的情况可以省略
//        ringBuffer.addGatingSequences(transProcessor.getSequence());
//        //把消息处理器提交到线程池
//        executorService.submit(transProcessor);

        CustomEventProducer<String> producer= new CustomEventProducer<>(ringBuffer);
        while(true){
            Scanner scan = new Scanner(System.in);
            String msg = scan.nextLine();
            if ("exit".equals(msg)) {
                //通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
                disruptor.halt();
                //终止线程
                executorService.shutdown();
            }
            producer.send(msg);
        }

    }

    public void start() {
        CustomEventFactory<CustomEvent<String>> eventFactory = new CustomEventFactory<CustomEvent<String>>();
        int bufferSize = 16;
        Disruptor<CustomEvent<String>> disruptor = new Disruptor(eventFactory, bufferSize,
                executorService);

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
                //终止线程
                executorService.shutdown();
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