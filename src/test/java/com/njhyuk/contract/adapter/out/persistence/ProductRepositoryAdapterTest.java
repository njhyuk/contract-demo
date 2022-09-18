package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ContextConfiguration(classes = ProductRepositoryAdapterTest.InnerTestConfiguration.class)
class ProductRepositoryAdapterTest {
  @Autowired
  ProductRepositoryAdapter productRepositoryAdapter;

  @Test
  @DisplayName("상품 DB 조회를 테스트 한다")
  void getProduct() {
    Product product = productRepositoryAdapter.getProduct(1L);

    assertAll(
        () -> assertThat(product.getId()).isEqualTo(1L),
        () -> assertThat(product.getName()).isEqualTo("여행자 보험")
    );
  }

  @Configuration
  @EnableJdbcRepositories(basePackageClasses = ProductRepository.class)
  @Import({ProductRepositoryAdapter.class, ProductEntityMapper.class})
  static class InnerTestConfiguration {

  }
}
