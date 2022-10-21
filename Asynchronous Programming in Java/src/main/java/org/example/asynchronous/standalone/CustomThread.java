package org.example.asynchronous.standalone;

import lombok.extern.slf4j.Slf4j;
import org.example.asynchronous.common.FactorialCalculator;
import org.example.asynchronous.common.FactorialCalculatorImpl;

@Slf4j
public class CustomThread extends Thread {

  private final FactorialCalculator factorialCalculator;
  private final int number;

  public CustomThread(int number) {
    this.number = number;
    this.factorialCalculator = new FactorialCalculatorImpl();
  }

  @Override
  public void run() {
    factorialCalculator.calculate(this.number);
  }
}
