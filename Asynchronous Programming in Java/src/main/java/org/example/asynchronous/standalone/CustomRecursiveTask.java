package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomRecursiveTask extends AbstractRecursiveAction{

    private final FactorialCalculator factorialCalculator;

    CustomRecursiveTask() {
        super(true);
        this.factorialCalculator = new FactorialCalculatorImpl();
    }

    @Override
    protected void compute() {
        try {
            factorialCalculator.calculate(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
