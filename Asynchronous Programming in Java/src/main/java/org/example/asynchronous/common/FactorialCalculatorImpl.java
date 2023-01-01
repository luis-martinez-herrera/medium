package org.example.asynchronous.common;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorialCalculatorImpl implements FactorialCalculator {

  @Override
  public long calculate(int number) {
    Instant start = Instant.now();

    String threadName = Thread.currentThread().getName();
    log.info("Start using thread: {}", threadName);

    long factorial = calculateFactorial(number);
    log.info("Factorial of {} is: {}", number, factorial);

    Instant end = Instant.now();
    log.info(
        "Finish using thread: {}. Total execution time: {}",
        threadName,
        Duration.between(start, end).toMillis());

    return factorial;
  }

  private long calculateFactorial(int n) {
    if (n == 0) {
      return 1;
    }

    return n * calculateFactorial(n - 1);
  }
}
