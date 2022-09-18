package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.adapter.in.web.v1.model.ContractDetailModel;
import com.njhyuk.contract.application.port.in.GetContractUseCase;
import com.njhyuk.contract.domain.Contract;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetContractController {
  private final GetContractUseCase getContractUseCase;

  @GetMapping("/v1/contracts/{contractNo}")
  public ContractDetailModel getContract(@PathVariable Long contractNo) {
    Contract contract = getContractUseCase.getContract(contractNo);

    return ContractDetailModel.from(contract);
  }
}
