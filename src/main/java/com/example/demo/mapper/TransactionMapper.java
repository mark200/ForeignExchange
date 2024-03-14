package com.example.demo.mapper;

import com.example.demo.dto.Conversion;
import com.example.demo.entities.ExchangeRate;
import com.example.demo.entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionMapper {
    public static Transaction dtoToEntity(Conversion input) {
        Transaction result = new Transaction(
                MapperUtils.mapUnitTime(input.info.timestamp),
                input.query.from,
                input.query.to,
                input.query.amount,
                input.info.quote,
                input.result
        );

        return result;
    }
}
