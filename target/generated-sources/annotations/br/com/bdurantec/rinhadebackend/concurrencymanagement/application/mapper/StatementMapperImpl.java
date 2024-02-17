package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.BalanceDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerStatementResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.TransactionDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Balance;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Statement;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-17T17:45:45-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class StatementMapperImpl implements StatementMapper {

    @Override
    public CustomerStatementResponseDTO toResponse(Statement statement) {
        if ( statement == null ) {
            return null;
        }

        BalanceDTO balance = null;

        balance = balanceToBalanceDTO( statement.balance() );

        List<TransactionDTO> transactions = null;

        CustomerStatementResponseDTO customerStatementResponseDTO = new CustomerStatementResponseDTO( balance, transactions );

        return customerStatementResponseDTO;
    }

    protected BalanceDTO balanceToBalanceDTO(Balance balance) {
        if ( balance == null ) {
            return null;
        }

        Long total = null;
        LocalDateTime statementConsultDate = null;
        Long limit = null;

        total = balance.getTotal();
        statementConsultDate = balance.getStatementConsultDate();
        limit = balance.getLimit();

        BalanceDTO balanceDTO = new BalanceDTO( total, statementConsultDate, limit );

        return balanceDTO;
    }
}
