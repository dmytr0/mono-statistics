package com.dmytr0.mono.monostat.dto;

import lombok.Data;

@Data
public class MonoStatement {
    private String id;
    private long time;
    private String description;
    private String comment;
    private int mcc;
    private int originalMcc;
    private int amount;
    private int operationAmount;
    private int currencyCode;
    private int commissionRate;
    private int cashbackAmount;
    private int balance;
    private boolean hold;
    private String receiptId;

}
