package com.manasi.corejava.multithreading;

import java.util.concurrent.*;
//import java.util.*;

public class ThreadDemo {
    // 1. volatile variable for visibility
    private static volatile int sharedCounter = 0;

    // 2. instance variable (needs synchronization)
    private int instanceCounter = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();
        
        // 3. Thread using Runnable
        Thread t1 = new Thread(demo::incrementInstanceSafe, "T1");
        // 4. Thread using synchronized block
        Thread t2 = new Thread(() -> {
            demo.incrementInstanceBlock();
        }, "T2");
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final instanceCounter (should be 2000): " + demo.instanceCounter);

        // 5. ThreadPoolExecutor
        ExecutorService executor = new ThreadPoolExecutor(
            2, 4, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " processing task " + id);
                demo.incrementShared(); // modifies volatile variable
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Final sharedCounter (5 expected): " + sharedCounter);
    }

    // synchronized method — thread-safe for instanceCounter
    public synchronized void incrementInstanceSafe() {
        for (int i = 0; i < 1000; i++) {
            instanceCounter++;
        }
    }

    // synchronized block — same safety using lock on this
    public void incrementInstanceBlock() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                instanceCounter++;
            }
        }
    }

    // modifies volatile sharedCounter — only visibility guaranteed
    public void incrementShared() {
        sharedCounter++;
    }
}
