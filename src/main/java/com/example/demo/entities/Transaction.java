package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private Instant timestamp;
    @Column(name = "source_currency")
    private String sourceCurrency;

    @Column(name = "taget_currency")
    private String targetCurrency;

    @Column(name = "source_amount")
    private float sourceAmount;

    @Column(name = "rate")
    private float rate;

    @Column(name = "taget_amount")
    private float targetAmount;

    public Transaction() {}

    public Transaction(Instant timestamp, String sourceCurrency, String targetCurrency, float sourceAmount, float rate, float targetAmount) {
        this.timestamp = timestamp;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.rate = rate;
        this.targetAmount = targetAmount;
    }

    public Long getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public float getSourceAmount() {
        return sourceAmount;
    }

    public float getRate() {
        return rate;
    }

    public float getTargetAmount() {
        return targetAmount;
    }
}
