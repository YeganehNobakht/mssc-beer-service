package com.bmc.msscbeerservice.events;

import com.bmc.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

/**
 * @author Masoumeh Yeganeh
 * @created 24/05/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionId = -12352148965212L;
    private BeerDto beerDto;
}
