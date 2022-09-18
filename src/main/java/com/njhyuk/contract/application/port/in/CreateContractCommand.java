package com.njhyuk.contract.application.port.in;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
public class CreateContractCommand {
  @NotNull(message = "상품번호는 필수입니다.")
  private final Long productNo;
  @NotNull(message = "계약기간은 필수입니다.")
  private final Integer contractTerm;
  @NotNull(message = "보험시작일은 필수입니다.")
  private final LocalDateTime startedAt;
  @NotNull(message = "담보번호 목록은 필수입니다.")
  private final Set<Long> guaranteeNos;
}
