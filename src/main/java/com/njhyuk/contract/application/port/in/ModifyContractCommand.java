package com.njhyuk.contract.application.port.in;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Builder
public class ModifyContractCommand {
  @NotNull(message = "계약상태는 필수입니다.")
  private final Integer status;
  @NotNull(message = "계약기간은 필수입니다.")
  private final Integer contractTerm;
  @NotNull(message = "담보번호 목록은 필수입니다.")
  private final Set<Long> guaranteeNos;
}
