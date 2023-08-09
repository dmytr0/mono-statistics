package com.dmytr0.mono.monostat.constants;

public final class MonoConstants {

    // (31 days + 1 hour) https://api.monobank.ua/docs/#tag/Kliyentski-personalni-dani/paths/~1personal~1statement~1{account}~1{from}~1{to}/get
    public static final long MAX_STATEMENT_DATE_RANGE_SECONDS = 2682000; // (31 days + 1 hour) https://api.monobank.ua/docs/#tag/Kliyentski-personalni-dani/paths/~1personal~1statement~1{account}~1{from}~1{to}/get

    public static final long MAX_REQUESTS_FREQUENCY_SECONDS = 65; // 60 seconds + 5 seconds for reserve
}
