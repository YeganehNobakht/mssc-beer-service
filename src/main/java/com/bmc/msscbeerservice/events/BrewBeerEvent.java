package com.bmc.msscbeerservice.events;

import com.bmc.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

/**
 * @author Masoumeh Yeganeh
 * @created 24/05/2023
 */
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
