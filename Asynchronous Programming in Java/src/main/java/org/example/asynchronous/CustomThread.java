package org.example.asynchronous;

public class CustomThread extends Thread{

    private final FactorialCalculator factorialCalculator;

    public CustomThread(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @Override
    public void run () {
        factorialCalculator.calculate();
    }
}
