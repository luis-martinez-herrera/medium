package org.example.asynchronous.standalone;

import java.util.concurrent.RecursiveAction;
import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomRecursiveAction extends RecursiveAction {

  private final FactorialCalculator factorialCalculator;
  private final int number;

  public CustomRecursiveAction(int number) {
    this.number = number;
    this.factorialCalculator = new FactorialCalculatorImpl();
  }

  @Override
  protected void compute() {
    this.factorialCalculator.calculate(this.number);
  }
}
