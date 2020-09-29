package com.promotion.engine.service;

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

@Service
public class PromotionCalculatorService {


    @Autowired
    PromotionEngineApplicationContext context;

    @Autowired
    SKUPricing skuPricing;

    public Integer calculateTotalPrice(Map<String, Integer> skuMap) {
        Integer totalPriceCalcuated = new Integer(0);
        boolean concurrentOfferApplied = false;
        if (context.getPrMethod().equals(PromotionalMethodEnum.DIRECT)) {
            if (skuMap.containsKey("C") && skuMap.containsKey("D")) {
                totalPriceCalcuated = totalPriceCalcuated + context.getConcurrentValue();
                concurrentOfferApplied = true;
            }
            Iterator<Map.Entry<String, Integer>> iterator = skuMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                String itemCode = entry.getKey();
                Integer itemCount = entry.getValue();
                if (itemCode.equalsIgnoreCase("A")) {
                    Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
                    Integer remainingItems = itemCount % context.getMultiplicationValueForA();
                    Integer itemCoupling = itemCount / context.getMultiplicationValueForA();
                    if (remainingItems >= 0) {
                        totalPriceCalcuated = totalPriceCalcuated + itemCoupling * (context.getCouplingValueForA()) + remainingItems * pricePerItem;
                    } else {
                        totalPriceCalcuated = totalPriceCalcuated + pricePerItem * itemCount;
                    }
                } else if (itemCode.equalsIgnoreCase("B")) {
                    Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
                    Integer remainingItems = itemCount % context.getMultiplicationValueForB();
                    Integer itemCoupling = itemCount / context.getMultiplicationValueForB();
                    if (remainingItems >= 0) {
                        totalPriceCalcuated = totalPriceCalcuated + itemCoupling * (context.getCouplingValueForB()) + remainingItems * pricePerItem;
                    } else {
                        totalPriceCalcuated = totalPriceCalcuated + pricePerItem * itemCount;
                    }
                } else if (!concurrentOfferApplied && (itemCode.equalsIgnoreCase("C") || skuMap.containsKey("D"))) {
                    Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
                    totalPriceCalcuated = totalPriceCalcuated + pricePerItem * itemCount;

                }

            }
        }
        return totalPriceCalcuated;
    }

}
