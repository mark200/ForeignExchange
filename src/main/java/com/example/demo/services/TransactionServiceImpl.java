package com.example.demo.services;

import com.example.demo.dto.Conversion;
import com.example.demo.entities.Transaction;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.repositories.TransactionRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private final RestTemplate restTemplate;

    private String baseUri;
    private String accessKey;

    public TransactionServiceImpl(@Value("${url.address}") String baseUri, @Value("${api.key}") String accessKey, RestTemplateBuilder builder) {
        this.restTemplate = builder.rootUri(baseUri).build();
        this.accessKey = accessKey;
        this.baseUri = baseUri;
    }

    @Override
    public Transaction addNewTransaction(Float amount, String source, String target) {
        String url = baseUri + "convert?access_key=" + accessKey + "&from=" + source + "&to" + target + "&amount=" + amount;
        ResponseEntity<String> responseString = restTemplate.getForEntity(url, String.class);

        Transaction newTransaction;

        try {
            Conversion conversion = new ObjectMapper().readValue(responseString.getBody(), Conversion.class);
            newTransaction = TransactionMapper.dtoToEntity(conversion);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return transactionRepo.save(newTransaction);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepo.findById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }
}
