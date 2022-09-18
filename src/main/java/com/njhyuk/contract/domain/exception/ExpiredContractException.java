package com.njhyuk.contract.domain.exception;

public class ExpiredContractException extends BusinessException {
  public ExpiredContractException() {
    super("기간만료 상태의 계약은 계약 변경 업무가 불가능합니다.");
  }
}
