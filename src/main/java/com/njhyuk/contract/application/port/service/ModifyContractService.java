package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.application.port.in.ModifyContractUseCase;
import com.njhyuk.contract.application.port.out.GetContractPort;
import com.njhyuk.contract.application.port.out.ModifyContractPort;
import com.njhyuk.contract.domain.Contract;
import com.njhyuk.contract.domain.exception.ExpiredContractException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@AllArgsConstructor
public class ModifyContractService implements ModifyContractUseCase {
  private final GetContractPort getContractPort;
  private final ModifyContractPort modifyContractPort;

  @Override
  @Transactional
  public Contract modifyContract(Long contractNo, ModifyContractCommand command) {
    Contract contract = getContractPort.getContract(contractNo);

    if (contract.isExpired()) {
      throw new ExpiredContractException();
    }

    return modifyContractPort.modify(contractNo, command);
  }
}
