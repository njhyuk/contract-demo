package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.application.port.in.CalculatorCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.Set;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.ARRAY;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CalculatorControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("예상 보험료를 계산 한다")
  void calculator() throws Exception {
    CalculatorCommand command = CalculatorCommand.builder()
        .productNo(1L)
        .contractTerm(11)
        .guaranteeNos(Set.of(1L, 2L))
        .build();

    when(expectAmountService.expectAmount(refEq(command)))
        .thenReturn(BigDecimal.valueOf(648_855.26));

    this.mockMvc.perform(
        post("/v1/calculator")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(command))
    ).andExpect(
        status().isOk()
    ).andDo(
        document("calculator",
            getDocumentRequest(),
            getDocumentResponse(),
            responseFields(
                fieldWithPath("productNo").type(NUMBER).description("상품 번호"),
                fieldWithPath("guaranteeNos").type(ARRAY).description("담보 번호 목록"),
                fieldWithPath("expectAmount").type(NUMBER).description("예상 보험료")
            )
        )
    );
  }
}

