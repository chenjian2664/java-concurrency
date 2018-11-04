package com.learn.concurrency.immutable;

import com.google.common.collect.Maps;
import com.learn.concurrency.annoations.NotThreadSafe;
import com.learn.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Created by chenjian
 * 2018/11/4 14:18
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
