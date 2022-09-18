package com.njhyuk.contract.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class ContractItems {
  private final List<ContractItem> items;

  public ContractItems(List<ContractItem> contractItems) {
    this.items = contractItems;
  }
}
