package com.njhyuk.contract.application.port.out;

import com.njhyuk.contract.domain.Product;

public interface GetProductPort {
  Product getProduct(Long productNo);
}
