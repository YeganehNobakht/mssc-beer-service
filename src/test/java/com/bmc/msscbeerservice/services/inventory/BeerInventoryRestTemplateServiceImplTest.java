package com.bmc.msscbeerservice.services.inventory;

import com.bmc.msscbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

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

//    final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");


    @BeforeEach
    void setup() {

    }

    @Test
    void getOnHandInventory() {
//        TODO: evolve to use upc
//        Integer onHandInventory = beerInventoryService.getOnHandInventory(BEER_1_UUID);
//        System.out.println(onHandInventory);
    }
}