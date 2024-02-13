package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {
	
	Optional<CustomerEntity> findById(Integer id);
	
	List<CustomerEntity> findAll();
}
