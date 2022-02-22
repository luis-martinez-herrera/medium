package org.example.asynchronous.dependent;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

import java.util.concurrent.*;

public class DependentMain {
    public static void main(String[] args) {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        DependentMain dependentMain = new DependentMain();
        dependentMain.runWithExecutorService();
    }

    private void runWithExecutorService() {
        FactorialCalculator factorialCalculator = new FactorialCalculatorImpl();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> factorialCalculator.calculate(5));
        Future<Integer> future2 = executor.submit(() -> factorialCalculator.calculate(5));

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

//    private void runWithCompletableFuture (){
//        FactorialCalculator factorialCalculator = new FactorialCalculatorImpl();
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            return factorialCalculator.calculate(5);
//        });
//    }
}
