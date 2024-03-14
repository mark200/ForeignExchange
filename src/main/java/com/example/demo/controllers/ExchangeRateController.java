package com.example.demo.controllers;

import com.example.demo.entities.ExchangeRate;
import com.example.demo.services.ExchangeRateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping(value = "/rates")
    public List<ExchangeRate> getRates() {
        return exchangeRateService.findAll();
    }

    @GetMapping(value = "/rates/{source}")
    public List<ExchangeRate> getRatesBySource(@PathVariable String source) {
        return exchangeRateService.fetchBySource(source);
    }

    @GetMapping(value = "/rates/{source}/{target}")
    public Optional<ExchangeRate> getExchangeRate(@PathVariable String source, @PathVariable String target) {
        return exchangeRateService.getExchangeRate(source, target);
    }
}
