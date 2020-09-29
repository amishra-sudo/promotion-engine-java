package com.promotion.engine.service;

import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.stereotype.Component;

@Component
public class PromotionEngineApplicationContext {


    private PromotionalMethodEnum prMethod;

    public PromotionalMethodEnum getPrMethod() {
        return prMethod;
    }

    public void setPrMethod(PromotionalMethodEnum prMethod) {
        this.prMethod = prMethod;
    }
}
