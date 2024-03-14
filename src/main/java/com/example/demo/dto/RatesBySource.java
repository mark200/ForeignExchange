package com.example.demo.dto;

import java.util.Map;

public class RatesBySource {
    public boolean success;
    public String terms;
    public String privacy;
    public Long timestamp;
    public String source;
    public Map<String, Float> quotes;
}
