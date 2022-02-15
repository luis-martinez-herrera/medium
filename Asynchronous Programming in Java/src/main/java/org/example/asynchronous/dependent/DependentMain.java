package org.example.asynchronous.dependent;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DependentMain {
    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        DependentMain dependentMain = new DependentMain();
        dependentMain.runWithExecutorService();
    }

    private void runWithExecutorService() {
        FactorialCalculator factorialCalculator1 = new FactorialCalculatorImpl(6);
        FactorialCalculator factorialCalculator2 = new FactorialCalculatorImpl(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(factorialCalculator1::calculate);
        Future<Integer> future2 =executor.submit(factorialCalculator2::calculate);

        while (true){
            if (future1.isDone() && future2.isDone()){
                break;
            }
        }

        try {
            System.out.println("Sum is: " + (future1.get() + future2.get()));
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
