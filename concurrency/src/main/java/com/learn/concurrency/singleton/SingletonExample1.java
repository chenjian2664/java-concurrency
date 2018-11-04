package com.learn.concurrency.singleton;

import com.learn.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chenjian
 * 2018/11/4 10:16
 * 懒汉模式 单例模式
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {
    // 私有构造函数
    private SingletonExample1() {}
    // 单例对象
    private static SingletonExample1 instance = null;
    // 静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
