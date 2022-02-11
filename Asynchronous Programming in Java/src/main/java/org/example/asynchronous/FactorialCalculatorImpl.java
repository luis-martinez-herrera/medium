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
    public void calculate() {
        Instant start = Instant.now();

        String threadName = Thread.currentThread().getName();

        System.out.println("Starting thread: " + threadName);
        try {
            System.out.println( threadName + " - Factorial of " + number + " is: " + calculateFactorial(number));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();

        System.out.println( threadName + " - Total execution time: " + Duration.between(start, end).toMillis());
    }

    private int calculateFactorial (int n) throws InterruptedException {
        Thread.sleep( ThreadLocalRandom.current().nextInt(500, 1000));

        if(n == 0) {
            return 1;
        }

        return n * calculateFactorial(n-1);
    }
}
