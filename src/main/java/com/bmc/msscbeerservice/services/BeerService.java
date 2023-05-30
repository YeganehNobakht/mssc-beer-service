package com.bmc.msscbeerservice.services;

import com.bmc.sfg.brewery.model.BeerDto;
import com.bmc.sfg.brewery.model.BeerPagedList;
import com.bmc.sfg.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId , Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
