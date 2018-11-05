package com.learn.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by chenjian
 * 2018/11/5 20:25
 */

@Slf4j
public class SemaphoreExample2 {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; ++i) {
            final int threadNum = i;
//            Thread.sleep(1);
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) { // 尝试获取一个许可
                        test(threadNum);
                        semaphore.release(); // 释放一个许可
                    }
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }
    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{}", threadNum);
//        Thread.sleep(100);
    }
}
