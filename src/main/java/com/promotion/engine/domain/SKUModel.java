package com.promotion.engine.domain;


import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "sku.config")
@Component
public class SKUModel {


    private String aName;
    private String bName;
    private String cName;
    private String dName;
    private Integer aPrice;
    private Integer bPrice;
    private Integer cPrice;
    private Integer dPrice;
    private Integer itemCount;
    private String itemCode;

    public SKUModel(int numberOfItems, String itemCode) {
        this.itemCount = numberOfItems;
        this.itemCode = itemCode;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

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

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "SKUModel{" +
                "aName='" + aName + '\'' +
                ", bName='" + bName + '\'' +
                ", cName='" + cName + '\'' +
                ", dName='" + dName + '\'' +
                ", aPrice=" + aPrice +
                ", bPrice=" + bPrice +
                ", cPrice=" + cPrice +
                ", dPrice=" + dPrice +
                '}';
    }
}
