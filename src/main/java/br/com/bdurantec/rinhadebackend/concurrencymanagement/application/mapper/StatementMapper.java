package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerStatementResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Statement;
import org.mapstruct.Mapper;

@Mapper
public interface StatementMapper {

  CustomerStatementResponseDTO toResponse(Statement statement);
}
