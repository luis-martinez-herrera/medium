package org.example.asynchronous.common;

import java.time.Duration;
import java.time.Instant;

public class FactorialCalculatorImpl implements FactorialCalculator {

    private final int number;

    public FactorialCalculatorImpl(int number) {
        this.number = number;
    }

    @Override
    public int calculate() throws InterruptedException{
        Instant start = Instant.now();

        String threadName = Thread.currentThread().getName();
        System.out.println(start + " Using thread: " + threadName);

        int factorial = calculateFactorial(number);
        System.out.println(Instant.now() + " " + threadName + " - Factorial of " + number + " is: " + factorial);

        Instant end = Instant.now();
        System.out.println(end + " " + threadName + " - Total execution time: " + Duration.between(start, end).toNanos());

        return factorial;
    }

    private int calculateFactorial (int n) throws InterruptedException {
        Thread.sleep( 900);

        if(n == 0) {
            return 1;
        }

        return n * calculateFactorial(n-1);
    }
}
