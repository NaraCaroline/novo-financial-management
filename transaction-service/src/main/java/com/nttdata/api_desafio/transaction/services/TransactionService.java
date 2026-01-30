package com.nttdata.api_desafio.transaction.services;

import com.nttdata.api_desafio.transaction.domain.Transaction;
import com.nttdata.api_desafio.transaction.dto.TransactionDto;
import com.nttdata.api_desafio.transaction.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction create(TransactionDto dto) {
        Transaction newTransaction = new Transaction(
                dto.description(),
                dto.amount(),
                dto.type(),
                dto.category()
        );
        return repository.save(newTransaction);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada."));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
