package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.TransactionRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper.TransactionEntityMapper;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper.TransactionEntityMapperImpl;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.TransactionJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionRepositoryImpl implements TransactionRepository {

  private final TransactionJpaRepository jpaRepository;
  private final TransactionEntityMapper mapper;

  public TransactionRepositoryImpl(TransactionJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
    this.mapper = new TransactionEntityMapperImpl();
  }

  @Override
  public Transaction save(Transaction transaction) {
    var transactionEntity = jpaRepository.save(mapper.toEntity(transaction));
    return mapper.toModel(transactionEntity);
  }
}
