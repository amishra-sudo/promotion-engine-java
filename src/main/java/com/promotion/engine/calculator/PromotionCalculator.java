package com.promotion.engine.calculator;

import com.promotion.engine.domain.SKUModel;
import com.promotion.engine.service.PromotionEngineApplicationContext;
import com.promotion.engine.service.SKUPricing;
import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PromotionCalculator {


    @Autowired
    PromotionEngineApplicationContext context;

    @Autowired
    SKUPricing skuPricing;

    public Integer createPromotion(SKUModel sku) {
        Integer itemPriceCalculated = new Integer(0);
        if (context.getPrMethod().equals(PromotionalMethodEnum.DIRECT)) {

            String itemCode = sku.getItemCode();
            Integer itemCount = sku.getItemCount();
            if (itemCode.equalsIgnoreCase("A") && itemCount >= 3) {
                Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
                Integer remainingItems = itemCount - 3;
                if (remainingItems > 0) {

                    itemPriceCalculated = 130 + remainingItems * pricePerItem;
                } else {
                    itemPriceCalculated = pricePerItem * itemCount;

                }


            }

        }
        return itemPriceCalculated;
    }

}
