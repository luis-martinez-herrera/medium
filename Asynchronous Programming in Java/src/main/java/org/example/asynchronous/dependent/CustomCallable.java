package org.example.asynchronous.dependent;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable <Integer> {

    private final FactorialCalculator factorialCalculator;
    private final int number;

    public CustomCallable(int number) {
        this.number = number;
        this.factorialCalculator = new FactorialCalculatorImpl();
    }

    @Override
    public Integer call() throws InterruptedException{
        return factorialCalculator.calculate(this.number);
    }
}