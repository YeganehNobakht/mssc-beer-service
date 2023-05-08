package com.bmc.msscbeerservice.web.controller;

import com.bmc.msscbeerservice.services.BeerService;
import com.bmc.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author yeganeh
 * @created 30/04/2023 - 11:52 AM
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){

        BeerDto getById = beerService.getById(beerId);
        return new ResponseEntity<>(getById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@Valid @RequestBody BeerDto beerDto){

        beerService.saveNewBeer(beerDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){

        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
