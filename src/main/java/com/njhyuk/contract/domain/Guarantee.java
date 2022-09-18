package com.njhyuk.contract.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Guarantee {
  private final Long id;
  private final Long productNo;
  private final String name;
  private final Integer guaranteeAmount;
  private final Integer baseAmount;
}
