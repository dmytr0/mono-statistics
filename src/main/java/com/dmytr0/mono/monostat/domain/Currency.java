package com.dmytr0.mono.monostat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@AllArgsConstructor
public enum Currency {
    UAH(980),
    EUR(978),
    USD(840);

    @Getter
    private int numericCode;

    public static Map<Integer, Currency> map = Arrays.stream(values()).collect(toMap(Currency::getNumericCode, Function.identity()));

    public static Currency getByNumericCode(int numericCode) {
        return map.get(numericCode);
    }
}
