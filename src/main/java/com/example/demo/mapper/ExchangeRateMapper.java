package com.example.demo.mapper;

import com.example.demo.dto.RatesBySource;
import com.example.demo.entities.ExchangeRate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRateMapper {
    public static List<ExchangeRate> dtoToInternalEntity(RatesBySource input) {
        List<ExchangeRate> result = new ArrayList<>();

        for (Map.Entry<String, Float> entry: input.quotes.entrySet()) {
            ExchangeRate newExchangeRate = new ExchangeRate(input.source,
                    mapTargetCurrency(input.source, entry.getKey()),
                    entry.getValue(),
                    MapperUtils.mapUnitTime(input.timestamp));
            result.add(newExchangeRate);
        }

        return result;
    }

    public static String mapTargetCurrency(String source, String sourceToTarget) {
        return sourceToTarget.substring(source.length());
    }
}
