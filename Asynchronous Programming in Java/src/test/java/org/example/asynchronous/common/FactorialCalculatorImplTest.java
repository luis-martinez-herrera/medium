package org.example.asynchronous.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialCalculatorImplTest {

  FactorialCalculator factorialCalculator = new FactorialCalculatorImpl();

  @Test
  @DisplayName("Calculate Factorial of 5")
  void calculate5() {
    assertEquals(120, factorialCalculator.calculate(5));
  }

  @Test
  @DisplayName("Calculate Factorial of 10")
  void calculate10() {
    assertEquals(3628800, factorialCalculator.calculate(10));
  }

  @Test
  @DisplayName("Calculate Factorial of 0")
  void calculate0() {
    assertEquals(1, factorialCalculator.calculate(0));
  }
}
