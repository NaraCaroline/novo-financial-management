package com.nttdata.api_desafio.transaction.repositories;

import com.nttdata.api_desafio.transaction.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUsername(String username);
    Optional<Transaction> findByIdAndUsername(Long id, String username);
}