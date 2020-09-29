package com.promotion.engine.service;

import com.promotion.engine.PromotionEngineApplicationTests;
import com.promotion.engine.domain.SKUModel;
import com.promotion.engine.util.PromotionalMethodEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {PromotionEngineApplicationTests.class})
@SpringBootTest
public class TestPromotionCalculatorService {
    @Autowired
    SKUModel skuModel;

    @Autowired
    PromotionEngineApplicationContext context;

    @Autowired
    PromotionCalculatorService promotionCalculatorService;

    @Test
    public void testScenarioA() {
        Map<String, Integer> mapOfSKUs = new HashMap<>();
        mapOfSKUs.put("A", 1);
        mapOfSKUs.put("B", 1);
        mapOfSKUs.put("C", 1);
        context.setPrMethod(PromotionalMethodEnum.DIRECT);
        Integer totalValueCalculated = promotionCalculatorService.calculateTotalPrice(mapOfSKUs);
        Assert.assertEquals(String.valueOf(totalValueCalculated), "100");
    }

    @Test
    public void testScenarioB() {
        Map<String, Integer> mapOfSKUs = new HashMap<>();
        mapOfSKUs.put("A", 5);
        mapOfSKUs.put("B", 5);
        mapOfSKUs.put("C", 1);
        context.setPrMethod(PromotionalMethodEnum.DIRECT);
        Integer totalValueCalculated = promotionCalculatorService.calculateTotalPrice(mapOfSKUs);
        Assert.assertEquals(String.valueOf(totalValueCalculated), "370");

    }

    @Test
    public void testScenarioC() {
        Map<String, Integer> mapOfSKUs = new HashMap<>();
        mapOfSKUs.put("A", 3);
        mapOfSKUs.put("B", 5);
        mapOfSKUs.put("C", 1);
        mapOfSKUs.put("D", 1);
        context.setPrMethod(PromotionalMethodEnum.DIRECT);
        Integer totalValueCalculated = promotionCalculatorService.calculateTotalPrice(mapOfSKUs);
        Assert.assertEquals(String.valueOf(totalValueCalculated), "280");

    }


}
