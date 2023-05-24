package com.bmc.msscbeerservice.events;

import com.bmc.msscbeerservice.web.model.BeerDto;

/**
 * @author Masoumeh Yeganeh
 * @created 24/05/2023
 */

public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
