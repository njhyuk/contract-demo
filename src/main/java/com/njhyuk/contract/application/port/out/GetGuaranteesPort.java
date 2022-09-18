package com.njhyuk.contract.application.port.out;

import com.njhyuk.contract.domain.Guarantees;

import java.util.Set;

public interface GetGuaranteesPort {
  Guarantees getGuarantees(Long productNo, Set<Long> guaranteeNos);
}
