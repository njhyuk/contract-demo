package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.Set;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ModifyContractControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("계약을 수정 한다")
  public void modifyContractTest() throws Exception {
    ModifyContractCommand command = ModifyContractCommand.builder()
        .status(0)
        .contractTerm(1)
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    Contract contract = Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1L))
        .build();

    when(modifyContractService.modifyContract(eq(100L), refEq(command)))
        .thenReturn(contract);

    this.mockMvc.perform(
        put("/v1/contracts/{contractNo}", 100L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(command))
    ).andExpect(
        status().isOk()
    ).andDo(
        document("contract/modify-contract",
            getDocumentRequest(),
            getDocumentResponse(),
            responseFields(
                fieldWithPath("contractNo").type(NUMBER).description("계약 번호")
            )
        )
    );
  }
}
