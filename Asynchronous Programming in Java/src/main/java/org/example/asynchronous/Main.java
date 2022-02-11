package org.example.asynchronous;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        FactorialCalculator factorialCalculator = new FactorialCalculatorImpl(5);

        CustomThread customThread = new CustomThread(factorialCalculator);
        customThread.start();

        CustomRunnable customRunnable = new CustomRunnable(factorialCalculator);
        Thread newThread = new Thread (customRunnable);
        newThread.start();
    }
}
