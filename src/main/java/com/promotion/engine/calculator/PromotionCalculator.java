package com.promotion.engine.calculator;

import com.promotion.engine.domain.SKUModel;
import com.promotion.engine.service.PromotionEngineApplicationContext;
import com.promotion.engine.service.SKUPricing;
import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class PromotionCalculator {


    @Autowired
    PromotionEngineApplicationContext context;

    @Autowired
    SKUPricing skuPricing;

    public Integer createPromotion(HashMap<String,Integer> skuMap) {
        Integer totalPriceCalcuated = new Integer(0);
        if (context.getPrMethod().equals(PromotionalMethodEnum.DIRECT)) {
            Iterator<Map.Entry<String, Integer>> iterator = skuMap.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                String itemCode = entry.getKey();
                Integer itemCount = entry.getValue();
                if (itemCode.equalsIgnoreCase("A") && itemCount >= 3) {
                    Integer pricePerItem = skuPricing.getPriceForItem(entry.getKey());
                    Integer remainingItems = itemCount % 3;
                    Integer itemCoupling = itemCount / 3;

                    if (remainingItems > 0) {

                        totalPriceCalcuated = itemCoupling * (130) + remainingItems * pricePerItem;
                    } else {
                        totalPriceCalcuated = pricePerItem * itemCount;

                    }


                } else if (itemCode.equalsIgnoreCase("B") && itemCount >= 2) {
                    Integer pricePerItem = skuPricing.getPriceForItem(entry.getKey());
                    Integer remainingItems = itemCount - 2;
                    Integer itemCoupling = itemCount / 3;
                    if (remainingItems > 0) {

                        totalPriceCalcuated = itemCoupling * (45) + remainingItems * pricePerItem;
                    } else {
                        totalPriceCalcuated = pricePerItem * itemCount;

                    }


                } else if (itemCode.equalsIgnoreCase("C") || itemCode.equalsIgnoreCase("D")) {



                }

            }
        }
        return totalPriceCalcuated;
    }

}
