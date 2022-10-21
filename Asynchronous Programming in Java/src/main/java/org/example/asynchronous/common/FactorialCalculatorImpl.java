package org.example.asynchronous.common;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorialCalculatorImpl implements FactorialCalculator {

  @Override
  public int calculate(int number) {
    Instant start = Instant.now();

    String threadName = Thread.currentThread().getName();
    log.info("Start using thread: {}", threadName);

    int factorial = calculateFactorial(number);
    log.info(Instant.now() + " " + threadName + " - Factorial of " + number + " is: " + factorial);

    Instant end = Instant.now();
    log.info("Finish using thread: {}. Total execution time: {}", threadName,
        Duration.between(start, end).toMillis());

    return factorial;
  }

  private int calculateFactorial(int n) {
    if (n == 0) {
      return 1;
    }

    return n * calculateFactorial(n - 1);
  }
}
