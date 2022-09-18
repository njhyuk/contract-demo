package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.domain.Guarantees;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@Table("CONTRACTS")
public class ContractEntity {
  @Id
  @Column("NO")
  private Long no;

  @Column("PRODUCT_NO")
  private Long productNo;

  @Column("PRODUCT_NAME")
  private String productName;

  @Column("CONTRACT_TERM")
  private Integer contractTerm;

  @Column("STARTED_AT")
  private LocalDateTime startedAt;

  @Column("ENDED_AT")
  private LocalDateTime endedAt;

  @Column("STATUS")
  private Integer status;

  @Column("CONTRACT_AMOUNT")
  private BigDecimal contractAmount;

  @MappedCollection(idColumn = "CONTRACT_NO", keyColumn = "ID")
  private Set<ContractItemEntity> contractItems;

  @Column("CREATED_AT")
  @CreatedDate
  private LocalDateTime createdAt;

  @Column("UPDATED_AT")
  @LastModifiedDate
  private LocalDateTime updatedAt;

  public void modifyStatus(Integer status) {
    this.status = status;
  }

  public void modifyContractTerm(Integer contractTerm) {
    this.contractTerm = contractTerm;
    this.endedAt = startedAt.plusMonths(contractTerm);
  }

  public void modifyContractAmount(BigDecimal contractAmount) {
    this.contractAmount = contractAmount;
  }

  public void addContractItems(Guarantees guarantees) {
    this.contractItems = guarantees.getGuarantees()
        .stream()
        .map(guarantee -> ContractItemEntity.builder()
            .contractNo(no)
            .productNo(guarantee.getProductNo())
            .guaranteeNo(guarantee.getId())
            .guaranteeName(guarantee.getName())
            .guaranteeAmount(guarantee.getGuaranteeAmount())
            .baseAmount(guarantee.getBaseAmount())
            .build())
        .collect(Collectors.toSet());
  }
}
