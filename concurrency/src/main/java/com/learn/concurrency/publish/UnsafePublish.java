package com.learn.concurrency.publish;

import com.learn.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by chenjian
 * 2018/11/4 10:01
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish publish = new UnsafePublish();
        log.info("{}",Arrays.toString(publish.getStates()));

        publish.getStates()[0] = "d";
        log.info("{}",Arrays.toString(publish.getStates()));

    }
}
