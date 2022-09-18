package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.domain.Contract;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.Set;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateContractControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("계약을 생성 한다")
  public void createContractTest() throws Exception {
    CreateContractCommand command = CreateContractCommand.builder()
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    Contract contract = Contract.builder()
        .no(100L)
        .productNo(1L)
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1))
        .build();

    when(createContractService.createContract(refEq(command)))
        .thenReturn(contract);

    this.mockMvc.perform(
        post("/v1/contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(command))
    ).andExpect(
        status().isOk()
    ).andDo(
        document("contract/create-contract",
            getDocumentRequest(),
            getDocumentResponse(),
            responseFields(
                fieldWithPath("contractNo").type(NUMBER).description("계약 번호")
            )
        )
    );
  }
}
