/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import so.lean.disruptor.event.CustomEvent;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: CustomEventFactory.java, v 0.1 2019-02-22 5:03 PM Exp $
 */
public class CustomEventFactory<T> implements EventFactory<CustomEvent<T>> {

    @Override
    public CustomEvent<T> newInstance() {
        return new CustomEvent();
    }
}