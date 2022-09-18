package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.adapter.in.web.v1.model.ModifiedContractModel;
import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.application.port.in.ModifyContractUseCase;
import com.njhyuk.contract.domain.Contract;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ModifyContractController {
  private final ModifyContractUseCase modifyContractUseCase;

  @PutMapping("/v1/contracts/{contractNo}")
  public ModifiedContractModel modifyContract(
      @RequestBody @Valid ModifyContractCommand modifyContractCommand,
      @PathVariable Long contractNo
  ) {
    Contract contract = modifyContractUseCase.modifyContract(contractNo, modifyContractCommand);

    return new ModifiedContractModel(contract.getNo());
  }
}
