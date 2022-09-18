package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.application.port.out.CreateContractPort;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateContractServiceTest {

  @Test
  @DisplayName("계약을 생성한다")
  void createContract() {
    CreateContractCommand createCommand = CreateContractCommand.builder()
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    CreateContractPort createContractPort = command -> Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1L))
        .build();

    CreateContractService createContractService = new CreateContractService(createContractPort);

    Contract contract = createContractService.createContract(createCommand);

    assertAll(
        () -> assertEquals(contract.getNo(), 100L),
        () -> assertEquals(contract.getContractTerm(), 1)
    );
  }
}
