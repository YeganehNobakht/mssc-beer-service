package com.bmc.msscbeerservice.services.inventory;

import com.bmc.msscbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Masoumeh Yeganeh
 * @created 13/05/2023
 */

@Disabled//utility for manual testing
@SpringBootTest
class BeerInventoryRestTemplateServiceImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setup() {

    }

    @Test
    void getOnHandInventory() {
        Integer onHandInventory = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);
        System.out.println(onHandInventory);
    }
}