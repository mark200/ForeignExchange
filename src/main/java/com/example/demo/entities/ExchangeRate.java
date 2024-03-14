package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "source_currency")
    private String sourceCurrency;

    @Column(name = "target_currency")
    private String targetCurrency;

    @Column(name = "rate")
    private float rate;

    @Column(name = "valid_until")
    private Instant validUntil;

    public ExchangeRate(){}

    public ExchangeRate(String sourceCurrency, String targetCurrency, float rate, Instant validUntil) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
        this.validUntil = validUntil;
    }

    public Long getId() {
        return id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public float getRate() {
        return rate;
    }

    public Instant getValidUntil() {
        return validUntil;
    }
}
