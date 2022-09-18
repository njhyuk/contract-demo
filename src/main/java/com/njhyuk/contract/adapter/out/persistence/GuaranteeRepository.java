package com.njhyuk.contract.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;

import java.util.Set;

public interface GuaranteeRepository extends CrudRepository<GuaranteeEntity, Long> {
  Streamable<GuaranteeEntity> findByProductNoAndIdIn(Long productNo, Set<Long> ids);
}
