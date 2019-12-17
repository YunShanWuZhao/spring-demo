package com.example.spring.model;

import javax.validation.constraints.NotNull;

public class StatisticsInfo {

    private String name;

    @NotNull
    private String merchantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
