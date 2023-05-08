package com.bmc.msscbeerservice.web.mapper;

import com.bmc.msscbeerservice.domain.Beer;
import com.bmc.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}