package com.njhyuk.contract.adapter.in.web.v1.model;

public class CreatedContractModel {
  private final Long contractNo;

  public CreatedContractModel(Long contractNo) {
    this.contractNo = contractNo;
  }

  public Long getContractNo() {
    return contractNo;
  }
}
