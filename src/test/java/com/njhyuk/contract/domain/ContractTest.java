package com.njhyuk.contract.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {

  @Test
  @DisplayName("계약 상태 만료 여부를 체크 한다")
  void isExpired() {
    Contract contract = Contract.builder()
        .no(100L)
        .productNo(1L)
        .productName("여행자 보험")
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1))
        .status(ContractStatus.EXPIRED)
        .contractAmount(BigDecimal.valueOf(10000))
        .build();

    assertTrue(contract.isExpired());
  }
}
