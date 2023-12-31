package com.bmc.msscbeerservice.services.brewing;

import com.bmc.msscbeerservice.config.JmsConfig;
import com.bmc.msscbeerservice.domain.Beer;
import com.bmc.sfg.brewery.model.events.BrewBeerEvent;
import com.bmc.msscbeerservice.repository.BeerRepository;
import com.bmc.msscbeerservice.services.inventory.BeerInventoryService;
import com.bmc.msscbeerservice.web.mapper.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Masoumeh Yeganeh
 * @created 24/05/2023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void  checkForLowInventory(){
        List<Beer> beers =  beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if (beer.getMinOnHand() >= invQOH){
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE , new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
