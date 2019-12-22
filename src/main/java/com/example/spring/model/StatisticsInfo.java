package com.example.spring.model;


import com.example.spring.annotation.NotNull;

public class StatisticsInfo {

    private String name;

    @NotNull
    private String merchantId;

    @NotNull
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
