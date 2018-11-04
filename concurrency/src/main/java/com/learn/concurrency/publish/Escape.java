package com.learn.concurrency.publish;

import com.learn.concurrency.annoations.NotRecommend;
import com.learn.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chenjian
 * 2018/11/4 10:07
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape() {}

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
