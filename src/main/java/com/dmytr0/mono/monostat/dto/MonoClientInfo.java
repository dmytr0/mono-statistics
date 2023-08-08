package com.dmytr0.mono.monostat.dto;

import lombok.Data;

import java.util.List;

@Data
public class MonoClientInfo {

    private String clientId;
    private String name;
    private String webHookUrl;
    private String permissions;
    private List<MonoAccount> accounts;

}
