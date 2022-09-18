package com.njhyuk.contract.application.port.service;

import com.njhyuk.contract.application.port.in.CalculatorCommand;
import com.njhyuk.contract.application.port.in.ExpectAmountUseCase;
import com.njhyuk.contract.application.port.out.GetGuaranteesPort;
import com.njhyuk.contract.domain.Calculator;
import com.njhyuk.contract.domain.Guarantees;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class ExpectAmountService implements ExpectAmountUseCase {
  private final GetGuaranteesPort getGuaranteesPort;

  @Override
  public BigDecimal expectAmount(CalculatorCommand command) {
    Guarantees guarantees = getGuaranteesPort.getGuarantees(command.getProductNo(), command.getGuaranteeNos());
    
    return Calculator.calculate(command.getContractTerm(), guarantees);
  }
}
