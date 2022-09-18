package com.njhyuk.contract.adapter.in.web.v1.model;

public class ModifiedContractModel {
  private final Long contractNo;

  public ModifiedContractModel(Long contractNo) {
    this.contractNo = contractNo;
  }

  public Long getContractNo() {
    return contractNo;
  }
}
