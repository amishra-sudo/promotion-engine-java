package com.promotion.engine.service;

import com.promotion.engine.PromotionEngineApplicationTests;
import com.promotion.engine.domain.SKUModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {PromotionEngineApplicationTests.class})
@SpringBootTest
public class TestPromotionCalculator {
    @Autowired
    SKUModel skuModel;

    @Test
    public void testScenarioA() {
        SKUModel skuA = new SKUModel(1, "A");
        SKUModel skuB = new SKUModel(1, "B");
        SKUModel skuC = new SKUModel(1, "C");



    }
}
