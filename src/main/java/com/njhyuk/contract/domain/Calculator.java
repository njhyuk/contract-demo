package com.njhyuk.contract.domain;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@AllArgsConstructor
public class Calculator {
  private static final int TRUNCATE_DECIMAL_PLACE = 3;

  public static BigDecimal calculate(Integer contractTerm, Guarantees guarantees) {
    return BigDecimal.valueOf(contractTerm)
        .multiply(calculateItemsAll(guarantees))
        .setScale(TRUNCATE_DECIMAL_PLACE - 1, RoundingMode.FLOOR);
  }

  private static BigDecimal calculateItemsAll(Guarantees guarantees) {
    return guarantees.getGuarantees()
        .stream()
        .map(Calculator::calculateItemAmount)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }

  public static BigDecimal calculateItemAmount(Guarantee guarantee) {
    return BigDecimal.valueOf(guarantee.getGuaranteeAmount())
        .divide(BigDecimal.valueOf(guarantee.getBaseAmount()), MathContext.DECIMAL128);
  }
}
