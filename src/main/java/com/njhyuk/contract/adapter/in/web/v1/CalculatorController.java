package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.adapter.in.web.v1.model.CalculatorModel;
import com.njhyuk.contract.application.port.in.CalculatorCommand;
import com.njhyuk.contract.application.port.in.ExpectAmountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CalculatorController {
  private final ExpectAmountUseCase expectAmountUseCase;

  @PostMapping("/v1/calculator")
  public CalculatorModel calculator(
      @RequestBody @Valid CalculatorCommand command
  ) {
    BigDecimal expectAmount = expectAmountUseCase.expectAmount(command);

    return new CalculatorModel(
        command.getProductNo(),
        command.getGuaranteeNos(),
        expectAmount
    );
  }
}
