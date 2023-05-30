package com.bmc.msscbeerservice.services.brewing;

import com.bmc.msscbeerservice.config.JmsConfig;
import com.bmc.msscbeerservice.domain.Beer;
import com.bmc.sfg.brewery.model.events.BrewBeerEvent;
import com.bmc.sfg.brewery.model.events.NewInventoryEvent;
import com.bmc.msscbeerservice.repository.BeerRepository;
import com.bmc.sfg.brewery.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Masoumeh Yeganeh
 * @created 27/05/2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BrewingBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewing beer " + beer.getMinOnHand()+ " QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
