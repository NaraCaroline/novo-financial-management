package com.nttdata.api_desafio.transaction.controller;

import com.nttdata.api_desafio.transaction.domain.Transaction;
import com.nttdata.api_desafio.transaction.dto.TransactionDto;
import com.nttdata.api_desafio.transaction.dto.TransactionSummaryDto;
import com.nttdata.api_desafio.transaction.dto.TransactionUpdateDto;
import com.nttdata.api_desafio.transaction.repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<TransactionSummaryDto> create(@RequestBody @Valid TransactionDto data, @RequestParam String username) {
        var transaction = new Transaction(data, username);
        repository.save(transaction);
        return ResponseEntity.status(201).body(new TransactionSummaryDto(transaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionSummaryDto>> list(@RequestParam String username) {
        List<TransactionSummaryDto> transactions = repository.findByUsername(username).stream().map(TransactionSummaryDto::new).toList();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionSummaryDto> getById(@PathVariable Long id, @RequestParam String username) {
        var transaction = repository.findByIdAndUsername(id, username).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(new TransactionSummaryDto(transaction));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TransactionSummaryDto> update(@PathVariable Long id, @RequestBody @Valid TransactionUpdateDto data, @RequestParam String username) {
        var transaction = repository.findByIdAndUsername(id, username).orElseThrow(EntityNotFoundException::new);
        transaction.updateInfo(data);
        repository.save(transaction);
        return ResponseEntity.ok(new TransactionSummaryDto(transaction));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestParam String username) {
        var transaction = repository.findByIdAndUsername(id, username).orElseThrow(EntityNotFoundException::new);
        repository.delete(transaction);
        return ResponseEntity.ok("Transação deletada com sucesso.");
    }
}