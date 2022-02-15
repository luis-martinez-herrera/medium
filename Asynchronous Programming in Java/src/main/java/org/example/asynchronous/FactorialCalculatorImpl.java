package org.example.asynchronous;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class FactorialCalculatorImpl implements FactorialCalculator {

    private final int number;

    public FactorialCalculatorImpl(int number) {
        this.number = number;
    }

    @Override
    public int calculate() throws InterruptedException{
        Instant start = Instant.now();

        String threadName = Thread.currentThread().getName();
        System.out.println("Using thread: " + threadName);

        int factorial = calculateFactorial(number);
        System.out.println(threadName + " - Factorial of " + number + " is: " + factorial);

        Instant end = Instant.now();
        System.out.println( threadName + " - Total execution time: " + Duration.between(start, end).toMillis());

        return factorial;
    }

    private int calculateFactorial (int n) throws InterruptedException {
        Thread.sleep( ThreadLocalRandom.current().nextInt(200, 1000));

        if(n == 0) {
            return 1;
        }

        return n * calculateFactorial(n-1);
    }
}
