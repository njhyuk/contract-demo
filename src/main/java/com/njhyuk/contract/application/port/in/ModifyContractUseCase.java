package com.njhyuk.contract.application.port.in;

import com.njhyuk.contract.domain.Contract;

public interface ModifyContractUseCase {
  Contract modifyContract(Long contractNo, ModifyContractCommand command);
}
