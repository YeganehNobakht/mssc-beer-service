package com.bmc.msscbeerservice.bootstrap;

import com.bmc.msscbeerservice.domain.Beer;
import com.bmc.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();

    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStile("IPA")
                    .quantityToBrew(200)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());


            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStile("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(337010000002L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());

        }
        System.out.println("Loaded Beers:" + beerRepository.count());
    }
}
