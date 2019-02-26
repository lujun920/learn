/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor.event;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: TradeEvent.java, v 0.1 2019-02-21 1:59 PM Exp $
 */
@Data
public class TradeEvent {
    private String tradeNo;
    private int amount;
    private Date tradeTime;
}