package com.njhyuk.contract.application.port.out;

import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.domain.Contract;

public interface CreateContractPort {
  Contract create(CreateContractCommand command);
}
