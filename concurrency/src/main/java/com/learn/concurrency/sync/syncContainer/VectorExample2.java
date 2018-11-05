package com.learn.concurrency.sync.syncContainer;

import java.util.Vector;

/**
 * Created by chenjian
 * 2018/11/5 7:53
 */
public class VectorExample2 {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            vector.add(i);
        }
        while (true) {
            for (int i = 0; i < 10; ++i)
                vector.add(i);

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); ++i)
                        vector.remove(i);
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); ++i)
                        vector.get(i);
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
