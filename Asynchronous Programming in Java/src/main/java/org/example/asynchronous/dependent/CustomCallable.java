package org.example.asynchronous.dependent;

import org.example.asynchronous.common.FactorialCalculator;
import java.util.concurrent.Callable;

public class CustomCallable implements Callable <Integer> {

    private final FactorialCalculator factorialCalculator;

    public CustomCallable(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @Override
    public Integer call() throws InterruptedException{
        return factorialCalculator.calculate();
    }
}