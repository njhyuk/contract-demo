package com.njhyuk.contract.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("CONTRACT_ITEMS")
public class ContractItemEntity {
  @Id
  @Column("ID")
  private final Long id;

  @Column("CONTRACT_NO")
  private final Long contractNo;

  @Column("PRODUCT_NO")
  private final Long productNo;

  @Column("GUARANTEE_NO")
  private final Long guaranteeNo;

  @Column("GUARANTEE_NAME")
  private final String guaranteeName;

  @Column("GUARANTEE_AMOUNT")
  private final Integer guaranteeAmount;

  @Column("BASE_AMOUNT")
  private final Integer baseAmount;
}
