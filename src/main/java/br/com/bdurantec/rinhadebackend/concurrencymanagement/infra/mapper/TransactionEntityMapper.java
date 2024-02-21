package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionEntityMapper {

  Transaction toModel(TransactionEntity transactionEntity);

  default TransactionEntity toEntity(Transaction transaction) {
    if (transaction == null) {
      return null;
    }
    return new TransactionEntity(
        transaction.value(),
        transaction.type(),
        transaction.description()
    );
  }
}
