package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {
  protected Product bind(ProductEntity entity) {
    return Product.builder()
        .id(entity.getId())
        .name(entity.getName())
        .minContractTerm(entity.getMinContactTerm())
        .maxContractTerm(entity.getMaxContractTerm())
        .build();
  }
}
