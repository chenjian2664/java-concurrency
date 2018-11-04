package com.learn.concurrency.singleton;

import com.learn.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chenjian
 * 2018/11/4 10:16
 * 饿汉模式 单例模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {
    // 私有构造函数
    private SingletonExample6() {}
    // 单例对象
    private static SingletonExample6 instance = null;
    static {
        instance = new SingletonExample6();
    }
    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
