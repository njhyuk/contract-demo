package com.njhyuk.contract.adapter.in.web.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CalculatorModel {
  private final Long productNo;
  private final Set<Long> guaranteeNos;
  private final BigDecimal expectAmount;
}
