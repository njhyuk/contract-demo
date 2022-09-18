package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.application.port.out.GetGuaranteesPort;
import com.njhyuk.contract.application.port.out.GetProductPort;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJdbcTest
@ContextConfiguration(classes = ContractRepositoryAdapterTest.InnerTestConfiguration.class)
class ContractRepositoryAdapterTest {
  @Autowired
  ContractRepositoryAdapter contractRepositoryAdapter;

  @Test
  @DisplayName("계약 정보 DB 조회를 테스트 한다")
  void getContract() {
    Contract contract = contractRepositoryAdapter.getContract(1L);

    assertAll(
        () -> assertThat(contract.getNo()).isEqualTo(1L),
        () -> assertThat(contract.getProductName()).isEqualTo("항공기 지연도착 시 보상금")
    );
  }

  @MockBean({GetProductPort.class, GetGuaranteesPort.class})
  @EnableJdbcRepositories(basePackageClasses = {ContractRepository.class})
  @Import({ContractRepositoryAdapter.class, ContractEntityMapper.class})
  static class InnerTestConfiguration {
  }
}
