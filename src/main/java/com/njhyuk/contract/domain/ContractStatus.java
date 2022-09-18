package com.njhyuk.contract.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ContractStatus {
  NORMAL(0, "정상계약"),
  WITHDRAWN(1, "청약철회"),
  EXPIRED(2, "기간만료");

  private final Integer value;
  private final String name;

  ContractStatus(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  public static ContractStatus from(Integer status) {
    return Arrays.stream(values())
        .filter(v -> v.value.equals(status))
        .findFirst()
        .orElse(NORMAL);
  }
}
