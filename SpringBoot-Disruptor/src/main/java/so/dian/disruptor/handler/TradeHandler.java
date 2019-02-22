/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.dian.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.LifecycleAware;
import lombok.extern.slf4j.Slf4j;
import so.dian.disruptor.event.TradeEvent;

import java.util.Date;
import java.util.UUID;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: TradeHandler.java, v 0.1 2019-02-21 2:02 PM Exp $
 */
@Slf4j
public class TradeHandler implements EventHandler<TradeEvent>, LifecycleAware {
    @Override
    public void onEvent(TradeEvent event, long sequence, boolean endOfBatch) throws Exception {
        event.setTradeNo(UUID.randomUUID().toString());
        event.setTradeTime(new Date());
//        event.setAmount(100);
        log.info("TradeEvent: {}", event.toString());
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onShutdown() {

    }
}