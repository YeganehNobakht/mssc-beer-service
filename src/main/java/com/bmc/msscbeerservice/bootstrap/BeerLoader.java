package com.bmc.msscbeerservice.bootstrap;

import com.bmc.msscbeerservice.domain.Beer;
import com.bmc.msscbeerservice.repository.BeerRepository;
import com.bmc.sfg.brewery.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "063124200036";
    public static final String BEER_2_UPC = "063124300019";
    public static final String BEER_3_UPC = "083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0)
            loadBeerObjects();

    }

    private void loadBeerObjects() {

        Beer b1 = Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle(BeerStyleEnum.IPA.name())
                .quantityToBrew(200)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("12.95"))
                .minOnHand(12)
                .build();


        Beer b2 = Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .quantityToBrew(200)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("12.95"))
                .minOnHand(12)
                .build();

        Beer b3 = Beer.builder()
                .beerName("No Hammers On The Bar")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .quantityToBrew(200)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("12.95"))
                .minOnHand(12)
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
}
}
