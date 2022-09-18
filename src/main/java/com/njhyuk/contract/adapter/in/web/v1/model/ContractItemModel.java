package com.njhyuk.contract.adapter.in.web.v1.model;

import com.njhyuk.contract.domain.ContractItem;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContractItemModel {
  private final Long guaranteeNo;
  private final String guaranteeName;
  private final Integer guaranteeAmount;
  private final Integer baseAmount;

  public static ContractItemModel from(ContractItem contractItem) {
    return ContractItemModel.builder()
        .guaranteeNo(contractItem.getGuaranteeNo())
        .guaranteeName(contractItem.getGuaranteeName())
        .guaranteeAmount(contractItem.getGuaranteeAmount())
        .baseAmount(contractItem.getBaseAmount())
        .build();
  }
}
