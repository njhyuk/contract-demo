package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.domain.Guarantee;
import org.springframework.stereotype.Component;

@Component
public class GuaranteeEntityMapper {
  protected Guarantee bind(GuaranteeEntity entity) {
    return Guarantee.builder()
        .id(entity.getId())
        .productNo(entity.getProductNo())
        .name(entity.getName())
        .guaranteeAmount(entity.getGuaranteeAmount())
        .baseAmount(entity.getBaseAmount())
        .build();
  }
}
