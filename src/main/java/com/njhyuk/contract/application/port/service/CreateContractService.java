package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.application.port.in.CreateContractUseCase;
import com.njhyuk.contract.application.port.out.CreateContractPort;
import com.njhyuk.contract.domain.Contract;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@AllArgsConstructor
public class CreateContractService implements CreateContractUseCase {
  private final CreateContractPort createContractPort;

  @Override
  @Transactional
  public Contract createContract(CreateContractCommand command) {
    return createContractPort.create(command);
  }
}
