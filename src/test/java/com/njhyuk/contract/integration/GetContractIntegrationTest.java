package com.njhyuk.contract.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetContractIntegrationTest extends AbstractIntegrationTest {
  @Test
  @DisplayName("계약 조회를 통합 테스트 한다")
  void getContractTest() throws Exception {
    mockMvc.perform(
            get("/v1/contracts/{contractNo}", 1L)
        ).andExpect(
            status().isOk()
        )
        .andExpect(jsonPath("contractNo").value(1L))
        .andExpect(jsonPath("productName").value("항공기 지연도착 시 보상금"));
  }
}
