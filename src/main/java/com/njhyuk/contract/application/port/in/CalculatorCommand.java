package com.njhyuk.contract.application.port.in;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class CalculatorCommand {
  private final Long productNo;
  private final Integer contractTerm;
  private final Set<Long> guaranteeNos;
}
