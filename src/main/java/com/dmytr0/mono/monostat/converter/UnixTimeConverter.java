package com.dmytr0.mono.monostat.converter;

import java.time.*;

public class UnixTimeConverter {

    public static LocalDateTime fromUnixTime(long unixTime) {
        Instant instant = Instant.ofEpochSecond(unixTime);
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static long toUnixTime(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).getEpochSecond();
    }
}
