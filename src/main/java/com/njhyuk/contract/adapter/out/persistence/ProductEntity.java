package com.njhyuk.contract.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("PRODUCTS")
public class ProductEntity {
  @Id
  @Column("ID")
  private Long id;

  @Column("NAME")
  private String name;

  @Column("MIN_CONTRACT_TERM")
  private Integer minContactTerm;

  @Column("MAX_CONTRACT_TERM")
  private Integer maxContractTerm;
}
