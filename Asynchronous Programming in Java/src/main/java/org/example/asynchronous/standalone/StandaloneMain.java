package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class StandaloneMain {

    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        StandaloneMain standaloneMain = new StandaloneMain();
//        standaloneMain.runWithThread();
//        standaloneMain.runWithRunnable();
//        standaloneMain.runWithExecutorService();
        standaloneMain.runWithCustomForkJoin();
    }

    private void runWithRunnable() {
        CustomRunnable customRunnable = new CustomRunnable(5);
        Thread newThread = new Thread (customRunnable);
        newThread.start();
    }

    private void runWithThread() {
        CustomThread customThread = new CustomThread(5);
        customThread.start();
    }

    private void runWithExecutorService() {
        CustomRunnable customRunnable1 = new CustomRunnable(5);
        CustomRunnable customRunnable2 = new CustomRunnable(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(customRunnable1);
        executor.submit(customRunnable2);

        executor.shutdown();
    }

    private void runWithCustomForkJoin (){
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction();
        commonPool.invoke(customRecursiveAction);
    }
}
