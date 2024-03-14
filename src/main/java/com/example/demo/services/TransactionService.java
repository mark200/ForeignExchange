package com.example.demo.services;


import com.example.demo.entities.ExchangeRate;
import com.example.demo.entities.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction addNewTransaction(Float amount, String source, String target);
    Optional<Transaction> findById(Long id);

    List<Transaction> findAll();
}
