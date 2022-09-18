package com.njhyuk.contract.application.port.in;

import java.math.BigDecimal;

public interface ExpectAmountUseCase {
  BigDecimal expectAmount(CalculatorCommand command);
}
