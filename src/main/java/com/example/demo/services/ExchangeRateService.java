package com.example.demo.services;

import com.example.demo.entities.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateService {
    Optional<ExchangeRate> findById(Long id);

    List<ExchangeRate> fetchBySource(String source);

    Optional<ExchangeRate> getExchangeRate(String source, String target);

    List<ExchangeRate> findAll();
}
