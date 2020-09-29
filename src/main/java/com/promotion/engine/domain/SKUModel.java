package com.promotion.engine.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sku.config")
@Component
public class SKUModel {
    private Integer aPrice;
    private Integer bPrice;
    private Integer cPrice;
    private Integer dPrice;
    public Integer getaPrice() {
        return aPrice;
    }

    public void setaPrice(Integer aPrice) {
        this.aPrice = aPrice;
    }

    public Integer getbPrice() {
        return bPrice;
    }

    public void setbPrice(Integer bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getcPrice() {
        return cPrice;
    }

    public void setcPrice(Integer cPrice) {
        this.cPrice = cPrice;
    }

    public Integer getdPrice() {
        return dPrice;
    }

    public void setdPrice(Integer dPrice) {
        this.dPrice = dPrice;
    }

}
