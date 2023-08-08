package com.dmytr0.mono.monostat.dto;

import lombok.Data;

import java.util.List;

@Data
public class MonoAccount {
    private String id;
    private String sendId;
    private String type;
    private String iban;
    private String cashbackType;
    private int currencyCode;
    private int balance;
    private int creditLimit;
    private List<String> maskedPan;
}
