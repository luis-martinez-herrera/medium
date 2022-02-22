package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomThread extends Thread{

    private final FactorialCalculator factorialCalculator;
    private final int number;

    public CustomThread(int number) {
        this.number = number;
        this.factorialCalculator = new FactorialCalculatorImpl();
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
