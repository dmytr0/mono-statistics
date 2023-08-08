package com.dmytr0.mono.monostat.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "mono_stat", name = "statements")
public class Statement {
    @Id
    private String id;
    private LocalDateTime time;
    private String description;
    private String comment;
    private int mcc;
    private int originalMcc;
    private int amount;
    private int operationAmount;
    @Enumerated(EnumType.STRING)
    private Currency currencyCode;
    private int commissionRate;
    private int cashbackAmount;
    private int balance;
    private boolean hold;
    private String receiptId;

}
