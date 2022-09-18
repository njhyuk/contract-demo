package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.application.port.out.GetContractPort;
import com.njhyuk.contract.application.port.out.ModifyContractPort;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModifyContractServiceTest {

  @Test
  @DisplayName("계약을 수정한다")
  void modifyContract() {
    ModifyContractCommand modifyCommand = ModifyContractCommand.builder()
        .status(0)
        .contractTerm(1)
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    GetContractPort getContractPort = contractNo -> Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1L))
        .build();
    ModifyContractPort modifyContractPort = (productNo, command) -> Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1L))
        .build();

    ModifyContractService modifyContractService = new ModifyContractService(getContractPort, modifyContractPort);

    Contract contract = modifyContractService.modifyContract(100L, modifyCommand);

    assertAll(
        () -> assertEquals(contract.getNo(), 100L),
        () -> assertEquals(contract.getContractTerm(), 1)
    );
  }
}
