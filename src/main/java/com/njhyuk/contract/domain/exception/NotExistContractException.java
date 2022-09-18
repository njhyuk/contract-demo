package com.njhyuk.contract.domain.exception;

public class NotExistContractException extends NotFoundException {
  public NotExistContractException(Long contractNo) {
    super(String.format("[계약번호:%s] 계약은 존재하지 않는 계약입니다.", contractNo));
  }
}
