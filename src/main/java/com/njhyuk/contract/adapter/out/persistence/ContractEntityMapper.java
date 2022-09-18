package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.domain.Contract;
import com.njhyuk.contract.domain.ContractItem;
import com.njhyuk.contract.domain.ContractItems;
import com.njhyuk.contract.domain.ContractStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContractEntityMapper {
  protected Contract bind(ContractEntity entity) {
    List<ContractItem> contractItems = entity.getContractItems()
        .stream()
        .map(this::bind)
        .collect(Collectors.toList());

    return Contract.builder()
        .no(entity.getNo())
        .productNo(entity.getProductNo())
        .productName(entity.getProductName())
        .contractAmount(entity.getContractAmount())
        .status(ContractStatus.from(entity.getStatus()))
        .contractTerm(entity.getContractTerm())
        .startedAt(entity.getStartedAt())
        .endedAt(entity.getEndedAt())
        .contractItems(new ContractItems(contractItems))
        .build();
  }

  protected ContractItem bind(ContractItemEntity entity) {
    return ContractItem.builder()
        .id(entity.getId())
        .contractNo(entity.getContractNo())
        .productNo(entity.getProductNo())
        .guaranteeNo(entity.getGuaranteeNo())
        .guaranteeName(entity.getGuaranteeName())
        .guaranteeAmount(entity.getGuaranteeAmount())
        .baseAmount(entity.getBaseAmount())
        .build();
  }
}
