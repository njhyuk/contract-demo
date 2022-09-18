package com.njhyuk.contract.adapter.out.persistence;

import com.njhyuk.contract.application.port.in.CreateContractCommand;
import com.njhyuk.contract.application.port.in.ModifyContractCommand;
import com.njhyuk.contract.application.port.out.CreateContractPort;
import com.njhyuk.contract.application.port.out.GetContractPort;
import com.njhyuk.contract.application.port.out.GetGuaranteesPort;
import com.njhyuk.contract.application.port.out.GetProductPort;
import com.njhyuk.contract.application.port.out.ModifyContractPort;
import com.njhyuk.contract.domain.Calculator;
import com.njhyuk.contract.domain.Contract;
import com.njhyuk.contract.domain.ContractStatus;
import com.njhyuk.contract.domain.Guarantees;
import com.njhyuk.contract.domain.Product;
import com.njhyuk.contract.domain.exception.NotExistContractException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@AllArgsConstructor
public class ContractRepositoryAdapter implements CreateContractPort, GetContractPort, ModifyContractPort {
  private final ContractRepository contractRepository;
  private final GetProductPort getProductPort;
  private final GetGuaranteesPort getGuaranteesPort;
  private final ContractEntityMapper mapper;

  @Override
  public Contract create(CreateContractCommand command) {
    Product product = getProductPort.getProduct(command.getProductNo());
    Guarantees guarantees = getGuaranteesPort.getGuarantees(command.getProductNo(), command.getGuaranteeNos());
    BigDecimal contractAmount = Calculator.calculate(command.getContractTerm(), guarantees);

    ContractEntity entity = ContractEntity.builder()
        .contractAmount(contractAmount)
        .contractTerm(command.getContractTerm())
        .status(ContractStatus.NORMAL.getValue())
        .startedAt(command.getStartedAt())
        .endedAt(command.getStartedAt().plusMonths(command.getContractTerm()))
        .productName(product.getName())
        .productNo(product.getId())
        .build();

    entity.addContractItems(guarantees);

    contractRepository.save(entity);

    return mapper.bind(entity);
  }

  @Override
  public Contract getContract(Long contractNo) {
    ContractEntity entity = contractRepository.findById(contractNo)
        .orElseThrow(() -> new NotExistContractException(contractNo));

    return mapper.bind(entity);
  }

  @Override
  public Contract modify(Long contractNo, ModifyContractCommand command) {
    ContractEntity entity = contractRepository.findById(contractNo)
        .orElseThrow(() -> new NotExistContractException(contractNo));

    entity.modifyStatus(command.getStatus());
    entity.modifyContractTerm(command.getContractTerm());

    Guarantees guarantees = getGuaranteesPort.getGuarantees(entity.getProductNo(), command.getGuaranteeNos());
    entity.addContractItems(guarantees);

    BigDecimal contractAmount = Calculator.calculate(command.getContractTerm(), guarantees);
    entity.modifyContractAmount(contractAmount);

    contractRepository.save(entity);

    return mapper.bind(entity);
  }
}
