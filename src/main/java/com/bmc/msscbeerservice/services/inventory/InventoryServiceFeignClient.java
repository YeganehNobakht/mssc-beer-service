package com.bmc.msscbeerservice.services.inventory;

import com.bmc.msscbeerservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

/**
 * @author Masoumeh Yeganeh
 * @created 27/06/2023
 */
@FeignClient(name = "inventory-service",configuration = FeignClientConfig.class)
public interface InventoryServiceFeignClient {

    @GetMapping(BeerInventoryRestTemplateServiceImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(@PathVariable UUID beerId);
}
