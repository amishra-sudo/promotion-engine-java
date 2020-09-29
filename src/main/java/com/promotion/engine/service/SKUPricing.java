package com.promotion.engine.service;

import com.promotion.engine.domain.SKUModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SKUPricing {

    @Autowired
    SKUModel sku;

    public int getPriceForItem(String itemCode) {
        int price;
        switch (itemCode) {
            case "A":
                price = sku.getaPrice();
                break;
            case "B":
                price = sku.getbPrice();
                break;
            case "C":
                price = sku.getcPrice();
                break;
            case "D":
                price = sku.getdPrice();
                break;
            default:
                price = 0;
                break;

        }
        return price;


    }


}
