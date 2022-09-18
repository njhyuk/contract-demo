package com.njhyuk.contract.application.port.out;

import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.domain.Contract;

public interface ModifyContractPort {
  Contract modify(Long contractNo, ModifyContractCommand command);
}
