package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomRunnable implements Runnable{

    private final FactorialCalculator factorialCalculator;
    private final int number;

    public CustomRunnable(int number) {
        this.factorialCalculator  = new FactorialCalculatorImpl();
        this.number = number;
    }

    @Override
    public void run () {
        try {
            factorialCalculator.calculate(this.number);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
