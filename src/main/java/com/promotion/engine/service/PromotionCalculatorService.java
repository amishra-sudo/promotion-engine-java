package com.promotion.engine.service;

import com.promotion.engine.util.PromotionalMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    totalPriceCalcuated = getCalculatedValueForItems(totalPriceCalcuated, itemCode,
                            itemCount, context.getMultiplicationValueForA(), context.getCouplingValueForA());
                } else if (itemCode.equalsIgnoreCase("B")) {
                    totalPriceCalcuated = getCalculatedValueForItems(totalPriceCalcuated, itemCode,
                            itemCount, context.getMultiplicationValueForB(), context.getCouplingValueForB());
                } else if (!concurrentOfferApplied && (itemCode.equalsIgnoreCase("C") || skuMap.containsKey("D"))) {
                    Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
                    totalPriceCalcuated = totalPriceCalcuated + pricePerItem * itemCount;
                }
            }
        }
        return totalPriceCalcuated;
    }

    private Integer getCalculatedValueForItems(Integer totalPriceCalcuated, String itemCode, Integer itemCount,
                                               Integer multiValue, Integer couplingVal) {
        Integer pricePerItem = skuPricing.getPriceForItem(itemCode);
        Integer remainingItems = itemCount % multiValue;
        Integer itemCoupling = itemCount / multiValue;
        if (remainingItems >= 0) {
            totalPriceCalcuated = totalPriceCalcuated + itemCoupling * (couplingVal) + remainingItems * pricePerItem;
        } else {
            totalPriceCalcuated = totalPriceCalcuated + pricePerItem * itemCount;
        }
        return totalPriceCalcuated;
    }

}
