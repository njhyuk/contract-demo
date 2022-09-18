package com.njhyuk.contract.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContractItem {
  private final Long id;
  private final Long contractNo;
  private final Long productNo;
  private final Long guaranteeNo;
  private final String guaranteeName;
  private final Integer guaranteeAmount;
  private final Integer baseAmount;
}
