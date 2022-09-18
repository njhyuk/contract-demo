package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.application.port.out.GetGuaranteesPort;
import com.njhyuk.contract.domain.Guarantee;
import com.njhyuk.contract.domain.Guarantees;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class GuaranteeRepositoryAdapter implements GetGuaranteesPort {
  private final GuaranteeRepository guaranteeRepository;
  private final GuaranteeEntityMapper mapper;

  @Override
  public Guarantees getGuarantees(Long productNo, Set<Long> guaranteeNos) {
    List<Guarantee> guarantees = guaranteeRepository.findByProductNoAndIdIn(productNo, guaranteeNos)
        .map(mapper::bind)
        .stream()
        .collect(Collectors.toList());
    
    return new Guarantees(guarantees);
  }
}
