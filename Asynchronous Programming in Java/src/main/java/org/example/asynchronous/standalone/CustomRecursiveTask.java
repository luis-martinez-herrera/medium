package org.example.asynchronous.standalone;

import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

public class CustomRecursiveTask extends AbstractRecursiveAction {

  private final FactorialCalculator factorialCalculator;

  CustomRecursiveTask() {
    super(true);
    this.factorialCalculator = new FactorialCalculatorImpl();
  }

  @Override
  protected void compute() {
    factorialCalculator.calculate(5);
  }
}
