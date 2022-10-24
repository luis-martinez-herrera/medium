package org.example.asynchronous.dependent;

import java.util.concurrent.Callable;
import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomCallable implements Callable<Long> {

  private final FactorialCalculator factorialCalculator;
  private final int number;

  public CustomCallable(int number) {
    this.number = number;
    this.factorialCalculator = new FactorialCalculatorImpl();
  }

  @Override
  public Long call() {
    return factorialCalculator.calculate(this.number);
  }
}
