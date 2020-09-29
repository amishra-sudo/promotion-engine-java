package com.promotion.engine.service;

import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.config")
public class PromotionEngineApplicationContext {


    private PromotionalMethodEnum prMethod;

    private Integer concurrentValue;

    private Integer couplingValueForA;

    private Integer couplingValueForB;

    private Integer multiplicationValueForA;

    private Integer multiplicationValueForB;



    public PromotionalMethodEnum getPrMethod() {
        return prMethod;
    }

    public void setPrMethod(PromotionalMethodEnum prMethod) {
        this.prMethod = prMethod;
    }

    public Integer getConcurrentValue() {
        return concurrentValue;
    }

    public void setConcurrentValue(Integer concurrentValue) {
        this.concurrentValue = concurrentValue;
    }

    public Integer getCouplingValueForA() {
        return couplingValueForA;
    }

    public void setCouplingValueForA(Integer couplingValueForA) {
        this.couplingValueForA = couplingValueForA;
    }

    public Integer getCouplingValueForB() {
        return couplingValueForB;
    }

    public void setCouplingValueForB(Integer couplingValueForB) {
        this.couplingValueForB = couplingValueForB;
    }

    public Integer getMultiplicationValueForA() {
        return multiplicationValueForA;
    }

    public void setMultiplicationValueForA(Integer multiplicationValueForA) {
        this.multiplicationValueForA = multiplicationValueForA;
    }

    public Integer getMultiplicationValueForB() {
        return multiplicationValueForB;
    }

    public void setMultiplicationValueForB(Integer multiplicationValueForB) {
        this.multiplicationValueForB = multiplicationValueForB;
    }
}
