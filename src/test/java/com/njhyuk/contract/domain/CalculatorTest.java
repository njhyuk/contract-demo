package com.njhyuk.contract.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  @DisplayName("담보의 [가입금액 / 기준금액] 을 계산 한다")
  void testCalculateItemAmount() {
    Guarantee guarantee = Guarantee.builder()
        .name("상해치료비")
        .guaranteeAmount(1_000_000)
        .baseAmount(100)
        .build();

    assertEquals(BigDecimal.valueOf(10000), Calculator.calculateItemAmount(guarantee));
  }

  @Test
  @DisplayName("담보의 계산된 금액이 소수점인 경우 최대 34자리까지 계산 한다")
  void testCalculateItemDecimal() {
    Guarantee guarantee = Guarantee.builder()
        .name("부분손실")
        .guaranteeAmount(750_000)
        .baseAmount(38)
        .build();

    assertEquals(
        BigDecimal.valueOf(750_000).divide(BigDecimal.valueOf(38), MathContext.DECIMAL128),
        Calculator.calculateItemAmount(guarantee));
  }

  @Test
  @DisplayName("보험 기간에 따른 보험료를 계산 한다 [납입기간 * 가입금액 / 기준금액]")
  void testCalculate() {
    Guarantees guarantees = new Guarantees(
        List.of(
            Guarantee.builder()
                .name("상해치료비")
                .guaranteeAmount(1_000_000)
                .baseAmount(100)
                .build()
        )
    );
    BigDecimal calculateAmount = Calculator.calculate(2, guarantees);

    assertEquals(20000, calculateAmount.intValue());
  }

  @Test
  @DisplayName("보험료는 소수점 3번째 자리에서 절사 한다")
  void testTruncateDecimal() {
    Guarantees guarantees = new Guarantees(
        List.of(
            Guarantee.builder()
                .name("부분손실")
                .guaranteeAmount(750_000)
                .baseAmount(38)
                .build()
        )
    );
    BigDecimal calculateAmount = Calculator.calculate(2, guarantees);

    assertEquals(BigDecimal.valueOf(39_473.68), calculateAmount);
  }

  @Test
  @DisplayName("각 담보별 계산된 값을 더한 뒤, 납입기간을 곱한다")
  void testSumGuaranteesCalculate() {
    Guarantees guarantees = new Guarantees(
        List.of(
            Guarantee.builder()
                .name("부분손실")
                .guaranteeAmount(750_000)
                .baseAmount(38)
                .build(),
            Guarantee.builder()
                .name("전체손실")
                .guaranteeAmount(1_570_000)
                .baseAmount(40)
                .build()
        )
    );

    BigDecimal calculateAmount = Calculator.calculate(11, guarantees);

    assertEquals(BigDecimal.valueOf(648_855.26), calculateAmount);
  }
}
