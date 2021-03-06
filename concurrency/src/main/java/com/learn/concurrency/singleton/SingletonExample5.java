package com.learn.concurrency.singleton;

import com.learn.concurrency.annoations.NotThreadSafe;
import com.learn.concurrency.annoations.ThreadSafe;

/**
 * Created by chenjian
 * 2018/11/4 10:16
 * 懒汉模式 单例模式
 * 双层同步锁单例模式
 */
@ThreadSafe
public class SingletonExample5 {
    // 私有构造函数
    private SingletonExample5() {}

    // 1、memory = allocate() 分配对象内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM 和 cpu优化发生了指令重排 可能会出现以下顺序：
    // 1、memory = allocate() 分配对象内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排序
    private volatile static SingletonExample5 instance = null;
    // 静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
