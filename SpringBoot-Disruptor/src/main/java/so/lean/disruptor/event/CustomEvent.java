/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.lean.disruptor.event;

import com.lmax.disruptor.EventFactory;
import lombok.Data;

/**
 * TODO
 *
 * @author ${baizhang}
 * @version $Id: CustomEvent.java, v 0.1 2019-02-22 5:07 PM Exp $
 */
@Data
public class CustomEvent<T> {
    private T obj;
    public static final EventFactory<CustomEvent> FACTORY = () -> new CustomEvent<>();
}