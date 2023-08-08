package com.dmytr0.mono.monostat.converter;

import com.dmytr0.mono.monostat.domain.Currency;
import com.dmytr0.mono.monostat.domain.Statement;
import com.dmytr0.mono.monostat.dto.MonoStatement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import static com.dmytr0.mono.monostat.converter.UnixTimeConverter.fromUnixTime;

@Component
public class StatementConverter {

    public Statement toEntity(MonoStatement monoStatement){
        var result = new Statement();
        BeanUtils.copyProperties(monoStatement, result, "time", "currencyCode");
        result.setTime(fromUnixTime(monoStatement.getTime()));
        result.setCurrencyCode(Currency.getByNumericCode(monoStatement.getCurrencyCode()));
        return result;
    }
}
