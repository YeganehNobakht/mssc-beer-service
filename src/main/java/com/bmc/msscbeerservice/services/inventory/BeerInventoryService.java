package com.bmc.msscbeerservice.services.inventory;

import java.util.UUID;

/**
 * @author Masoumeh Yeganeh
 * @created 13/05/2023
 */
public interface BeerInventoryService {

    Integer getOnHandInventory(UUID beerId);
}
