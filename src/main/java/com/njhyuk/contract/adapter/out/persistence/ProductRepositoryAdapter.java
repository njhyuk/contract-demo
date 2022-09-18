package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.application.port.out.GetProductPort;
import com.njhyuk.contract.domain.Product;
import com.njhyuk.contract.domain.exception.NotExistProductException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepositoryAdapter implements GetProductPort {
  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper;

  @Override
  public Product getProduct(Long productNo) {
    ProductEntity entity = productRepository.findById(productNo)
        .orElseThrow(() -> new NotExistProductException(productNo));

    return productEntityMapper.bind(entity);
  }
}
