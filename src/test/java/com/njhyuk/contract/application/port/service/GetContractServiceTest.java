package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.out.GetContractPort;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GetContractServiceTest {
  @Test
  @DisplayName("계약 상세 정보를 가져온다")
  void getContract() {
    GetContractPort getContractPort = contractNo -> Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1L))
        .build();

    GetContractService getContractService = new GetContractService(getContractPort);

    Contract contract = getContractService.getContract(100L);

    assertAll(
        () -> assertEquals(contract.getNo(), 100L),
        () -> assertEquals(contract.getContractTerm(), 1)
    );
  }
}
