package com.example.demo.services;

import com.example.demo.dto.RatesBySource;
import com.example.demo.entities.ExchangeRate;
import com.example.demo.mapper.ExchangeRateMapper;
import com.example.demo.repositories.ExchangeRateRepo;
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
public class ExchangeRaterServiceImpl implements ExchangeRateService{

    @Autowired
    private ExchangeRateRepo exchangeRateRepo;

    @Autowired
    private final RestTemplate restTemplate;

    private String baseUri;
    private String accessKey;

    public ExchangeRaterServiceImpl(@Value("${url.address}") String baseUri, @Value("${api.key}") String accessKey, RestTemplateBuilder builder) {
        this.restTemplate = builder.rootUri(baseUri).build();
        this.accessKey = accessKey;
        this.baseUri = baseUri;
    }

    @Override
    public Optional<ExchangeRate> findById(Long id) {
        return exchangeRateRepo.findById(id);
    }

    @Override
    public Optional<ExchangeRate> getExchangeRate(String source, String target) {
        List<ExchangeRate> ratesBySource = fetchBySource(source);
        return ratesBySource.stream().filter(x -> x.getTargetCurrency().equals(target)).findAny();
    }

    @Override
    public List<ExchangeRate> fetchBySource(String source) {
        String url = baseUri + "live?access_key=" + accessKey + "&source=" + source;
        ResponseEntity<String> responseString = restTemplate.getForEntity(url, String.class);

        List<ExchangeRate> listOfRates;
        try {
            RatesBySource ratesBySource = new ObjectMapper().readValue(responseString.getBody(), RatesBySource.class);
            listOfRates = ExchangeRateMapper.dtoToInternalEntity(ratesBySource);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return exchangeRateRepo.saveAll(listOfRates);
    }


    @Override
    public List<ExchangeRate> findAll() {
        return exchangeRateRepo.findAll();
    }
}
