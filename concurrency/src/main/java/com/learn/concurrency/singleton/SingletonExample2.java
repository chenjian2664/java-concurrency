package com.learn.concurrency.singleton;

import com.learn.concurrency.annoations.NotThreadSafe;
import com.learn.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chenjian
 * 2018/11/4 10:16
 * 饿汉模式 单例模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {
    // 私有构造函数
    private SingletonExample2() {}
    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();
    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
