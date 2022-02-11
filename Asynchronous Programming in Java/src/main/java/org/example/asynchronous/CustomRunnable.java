package org.example.asynchronous;

public class CustomRunnable implements Runnable{

    private final FactorialCalculator factorialCalculator;

    public CustomRunnable(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @Override
    public void run () {
        factorialCalculator.calculate();
    }
}
