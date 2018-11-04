package com.learn.concurrency.singleton;

import com.learn.concurrency.annoations.NotRecommend;
import com.learn.concurrency.annoations.NotThreadSafe;
import com.learn.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by chenjian
 * 2018/11/4 10:16
 * 懒汉模式 单例模式
 */
@Slf4j
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    // 私有构造函数
    private SingletonExample3() {}
    // 单例对象
    private static SingletonExample3 instance = null;
    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
