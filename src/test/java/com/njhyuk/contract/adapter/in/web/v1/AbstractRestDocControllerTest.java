package com.njhyuk.contract.adapter.in.web.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.njhyuk.contract.application.port.service.CreateContractService;
import com.njhyuk.contract.application.port.service.ExpectAmountService;
import com.njhyuk.contract.application.port.service.GetContractService;
import com.njhyuk.contract.application.port.service.ModifyContractService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@WebMvcTest
public class AbstractRestDocControllerTest {
  protected MockMvc mockMvc;

  @Autowired
  protected ObjectMapper objectMapper;

  @MockBean
  protected CreateContractService createContractService;

  @MockBean
  protected ModifyContractService modifyContractService;

  @MockBean
  protected GetContractService getContractService;

  @MockBean
  protected ExpectAmountService expectAmountService;

  @BeforeEach
  void init(WebApplicationContext webApplicationContext,
            RestDocumentationContextProvider restDocumentation) {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .alwaysDo(print())
        .build();
  }

  public static OperationRequestPreprocessor getDocumentRequest() {
    return preprocessRequest(prettyPrint());
  }

  public static OperationResponsePreprocessor getDocumentResponse() {
    return preprocessResponse(prettyPrint());
  }
}
