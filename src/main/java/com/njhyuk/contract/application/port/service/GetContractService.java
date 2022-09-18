package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.GetContractUseCase;
import com.njhyuk.contract.application.port.out.GetContractPort;
import com.njhyuk.contract.domain.Contract;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetContractService implements GetContractUseCase {
  private final GetContractPort getContractPort;

  @Override
  public Contract getContract(Long contractNo) {
    return getContractPort.getContract(contractNo);
  }
}
