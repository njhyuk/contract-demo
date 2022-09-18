package com.njhyuk.contract.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Guarantees {
  private final List<Guarantee> guarantees;

  public Guarantees(List<Guarantee> guarantees) {
    this.guarantees = guarantees;
  }

  public Integer size() {
    return guarantees.size();
  }
}
