package com.promotion.engine.domain;

import org.springframework.stereotype.Component;

@Component
public class PromotionModel {

    private boolean isPromotionAppliedForAItems;
    private boolean isPromotionAppliedForBItems;
    private boolean isPromotionAppliedForCnDItems;

    public boolean isPromotionAppliedForAItems() {
        return isPromotionAppliedForAItems;
    }

    public void setPromotionAppliedForAItems(boolean promotionAppliedForAItems) {
        isPromotionAppliedForAItems = promotionAppliedForAItems;
    }

    public boolean isPromotionAppliedForBItems() {
        return isPromotionAppliedForBItems;
    }

    public void setPromotionAppliedForBItems(boolean promotionAppliedForBItems) {
        isPromotionAppliedForBItems = promotionAppliedForBItems;
    }

    public boolean isPromotionAppliedForCnDItems() {
        return isPromotionAppliedForCnDItems;
    }

    public void setPromotionAppliedForCnDItems(boolean promotionAppliedForCnDItems) {
        isPromotionAppliedForCnDItems = promotionAppliedForCnDItems;
    }
}
