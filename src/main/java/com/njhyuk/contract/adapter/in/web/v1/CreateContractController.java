package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.adapter.in.web.v1.model.CreatedContractModel;
import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.application.port.in.CreateContractUseCase;
import com.njhyuk.contract.domain.Contract;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class CreateContractController {
  private final CreateContractUseCase createContractUseCase;

  @PostMapping("/v1/contracts")
  public CreatedContractModel createContract(
      @RequestBody @Valid CreateContractCommand createContractCommand
  ) {
    Contract contract = createContractUseCase.createContract(createContractCommand);

    return new CreatedContractModel(contract.getNo());
  }
}
