package com.example.demo.controllers;

import com.example.demo.entities.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.findAll();
    }

    @GetMapping(value = "/convert/{amount}/{source}/{target}")
    public Optional<Transaction> addNewTransaction(@PathVariable Float amount, @PathVariable String source, @PathVariable String target) {
        Transaction result = transactionService.addNewTransaction(amount, source, target);
        return Optional.of(result);
    }
}
