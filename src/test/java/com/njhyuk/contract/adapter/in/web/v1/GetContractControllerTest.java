package com.njhyuk.contract.adapter.in.web.v1;

import com.njhyuk.contract.domain.Contract;
import com.njhyuk.contract.domain.ContractItem;
import com.njhyuk.contract.domain.ContractItems;
import com.njhyuk.contract.domain.ContractStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GetContractControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("계약 상세 데이터를 가져 온다")
  void getContractTest() throws Exception {
    ContractItems contractItems = new ContractItems(
        List.of(
            ContractItem.builder()
                .id(1L)
                .contractNo(100L)
                .productNo(1L)
                .guaranteeNo(1L)
                .guaranteeName("상해치료비")
                .guaranteeAmount(1_000_000)
                .baseAmount(100)
                .build()
        )
    );

    Contract contract = Contract.builder()
        .no(100L)
        .productNo(1L)
        .productName("여행자 보험")
        .contractTerm(1)
        .startedAt(LocalDateTime.now())
        .endedAt(LocalDateTime.now().plusMonths(1))
        .contractItems(contractItems)
        .status(ContractStatus.NORMAL)
        .contractAmount(BigDecimal.valueOf(10000))
        .build();

    when(getContractService.getContract(100L))
        .thenReturn(contract);

    this.mockMvc.perform(
        get("/v1/contracts/{contractNo}", 100L)
    ).andExpect(
        status().isOk()
    ).andDo(
        document("contract/get-contract",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("contractNo").description("계약 번호")
            ),
            responseFields(
                fieldWithPath("contractNo").type(NUMBER).description("계약 번호"),
                fieldWithPath("productNo").type(NUMBER).description("상품 번호"),
                fieldWithPath("productName").type(STRING).description("상품명"),
                fieldWithPath("contractTerm").type(NUMBER).description("계약 기간"),
                fieldWithPath("startedAt").type(STRING).description("계약 시작일"),
                fieldWithPath("endedAt").type(STRING).description("계약 종료일"),
                fieldWithPath("status").type(NUMBER).description("계약 상태값"),
                fieldWithPath("statusMessage").type(STRING).description("계약 상태명"),
                fieldWithPath("contractAmount").type(NUMBER).description("총보험료"),
                fieldWithPath("contractItems[].guaranteeNo").type(NUMBER).description("담보 번호"),
                fieldWithPath("contractItems[].guaranteeName").type(STRING).description("담보명"),
                fieldWithPath("contractItems[].guaranteeAmount").type(NUMBER).description("가입금액"),
                fieldWithPath("contractItems[].baseAmount").type(NUMBER).description("기준금액")
            )
        )
    );
  }
}
