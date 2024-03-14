package com.example.demo.mapper;

import java.time.Instant;

public class MapperUtils {
    public static Instant mapUnitTime(Long timestamp) {
        return Instant.ofEpochSecond(timestamp);
    }
}
