package com.njhyuk.contract.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
  private final Long id;
  private final String name;
  private final Integer minContractTerm;
  private final Integer maxContractTerm;
}
