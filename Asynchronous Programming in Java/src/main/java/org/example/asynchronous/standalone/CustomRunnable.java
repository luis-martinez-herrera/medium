package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;

public class CustomRunnable implements Runnable{

    private final FactorialCalculator factorialCalculator;

    public CustomRunnable(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @Override
    public void run () {
        try {
            factorialCalculator.calculate();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
