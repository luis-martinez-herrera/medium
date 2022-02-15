package org.example.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        Main main = new Main();
//        main.runWithThread();
//        main.runWithRunnable();
//        main.runWithExecutorService();
        main.runWithCustomForkJoin();
    }

    private void runWithRunnable() {
        FactorialCalculator factorialCalculator = new FactorialCalculatorImpl(5);

        CustomRunnable customRunnable = new CustomRunnable(factorialCalculator);
        Thread newThread = new Thread (customRunnable);
        newThread.start();
    }

    private void runWithThread() {
        FactorialCalculator factorialCalculator = new FactorialCalculatorImpl(5);

        CustomThread customThread = new CustomThread(factorialCalculator);
        customThread.start();
    }

    private void runWithExecutorService() {
        FactorialCalculator factorialCalculator1 = new FactorialCalculatorImpl(5);
        FactorialCalculator factorialCalculator2 = new FactorialCalculatorImpl(5);

        CustomRunnable customRunnable1 = new CustomRunnable(factorialCalculator1);
        CustomRunnable customRunnable2 = new CustomRunnable(factorialCalculator2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(customRunnable1);
        executor.submit(customRunnable2);

        executor.shutdown();
    }

    private void runWithCustomForkJoin (){
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction(false);
        commonPool.invoke(customRecursiveAction);
    }
}
