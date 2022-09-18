package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.CalculatorCommand;
import com.njhyuk.contract.application.port.out.GetGuaranteesPort;
import com.njhyuk.contract.domain.Guarantee;
import com.njhyuk.contract.domain.Guarantees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExpectAmountServiceTest {

  @Test
  @DisplayName("예상 보험료를 계산 한다")
  void expectAmount() {
    GetGuaranteesPort getGuaranteesPort = (productNo, guaranteeNos) -> new Guarantees(
        List.of(
            Guarantee.builder()
                .id(1L)
                .productNo(1L)
                .name("부분손실")
                .guaranteeAmount(750_000)
                .baseAmount(38)
                .build(),
            Guarantee.builder()
                .id(2L)
                .productNo(1L)
                .name("전체손실")
                .guaranteeAmount(1_570_000)
                .baseAmount(40)
                .build()
        )
    );

    ExpectAmountService expectAmountService = new ExpectAmountService(getGuaranteesPort);

    CalculatorCommand command = CalculatorCommand.builder()
        .productNo(1L)
        .contractTerm(11)
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    BigDecimal expectAmount = expectAmountService.expectAmount(command);

    assertEquals(BigDecimal.valueOf(648_855.26), expectAmount);
  }
}
