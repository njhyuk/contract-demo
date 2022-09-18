package com.njhyuk.contract.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class Contract {
  private final Long no;
  private final Long productNo;
  private final String productName;
  private final Integer contractTerm;
  private final LocalDateTime startedAt;
  private final LocalDateTime endedAt;
  private final ContractStatus status;
  private final BigDecimal contractAmount;
  private final ContractItems contractItems;

  public Boolean isExpired() {
    return status == ContractStatus.EXPIRED;
  }
}
