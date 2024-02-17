package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Integer> {

  Optional<TransactionEntity> findById(Integer id);

  List<TransactionEntity> findAll();

  TransactionEntity save(TransactionEntity transactionEntity);
}
