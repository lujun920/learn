/*
 * Dian.so Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package so.dian.disruptor.event;

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
}