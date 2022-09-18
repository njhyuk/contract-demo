package com.njhyuk.contract.adapter.in.web.v1.model;

import com.njhyuk.contract.domain.Contract;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ContractDetailModel {
  private final Long contractNo;
  private final Long productNo;
  private final String productName;
  private final Integer contractTerm;
  private final LocalDateTime startedAt;
  private final LocalDateTime endedAt;
  private final Integer status;
  private final String statusMessage;
  private final BigDecimal contractAmount;
  private final List<ContractItemModel> contractItems;

  public static ContractDetailModel from(Contract contract) {
    return ContractDetailModel.builder()
        .contractNo(contract.getNo())
        .productNo(contract.getProductNo())
        .productName(contract.getProductName())
        .contractTerm(contract.getContractTerm())
        .startedAt(contract.getStartedAt())
        .endedAt(contract.getEndedAt())
        .status(contract.getStatus().getValue())
        .statusMessage(contract.getStatus().getName())
        .contractAmount(contract.getContractAmount())
        .contractItems(contract.getContractItems().getItems().stream()
            .map(ContractItemModel::from)
            .collect(Collectors.toList()))
        .build();
  }
}
