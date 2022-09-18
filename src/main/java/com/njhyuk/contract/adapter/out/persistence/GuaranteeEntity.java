package com.njhyuk.contract.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("GUARANTEES")
public class GuaranteeEntity {
  @Id
  @Column("ID")
  private final Long id;

  @Column("PRODUCT_NO")
  private final Long productNo;

  @Column("NAME")
  private final String name;

  @Column("GUARANTEE_AMOUNT")
  private final Integer guaranteeAmount;

  @Column("BASE_AMOUNT")
  private final Integer baseAmount;
}
