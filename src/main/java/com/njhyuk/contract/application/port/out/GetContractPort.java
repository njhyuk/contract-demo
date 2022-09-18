package com.njhyuk.contract.application.port.out;

import com.njhyuk.contract.domain.Contract;

public interface GetContractPort {
  Contract getContract(Long contractNo);
}
