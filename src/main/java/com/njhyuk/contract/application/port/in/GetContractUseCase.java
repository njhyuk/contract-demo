package com.njhyuk.contract.application.port.in;

import com.njhyuk.contract.domain.Contract;

public interface GetContractUseCase {
  Contract getContract(Long contractNo);
}
