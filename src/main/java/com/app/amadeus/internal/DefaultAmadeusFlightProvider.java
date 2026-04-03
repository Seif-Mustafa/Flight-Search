package com.app.amadeus.internal;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.app.amadeus.AmadeusFlightProvider;
import com.app.amadeus.FlightOfferDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
class DefaultAmadeusFlightProvider implements AmadeusFlightProvider {

    private final Amadeus amadeus;

    public DefaultAmadeusFlightProvider(Amadeus amadeus) {
        this.amadeus = amadeus;
    }

    @Override
    public List<FlightOfferDto> getFlightOffers(String origin, String destination, String departureDate) {
        try {
            FlightOfferSearch[] flightOffersSearch = amadeus.shopping.flightOffersSearch.get(
                    com.amadeus.Params.with("originLocationCode", origin)
                            .and("destinationLocationCode", destination)
                            .and("departureDate", departureDate)
                            .and("adults", 1)
                            .and("max", 5));

            return Arrays.stream(flightOffersSearch)
                    .map(offer -> FlightOfferDto.builder()
                            .price(offer.getPrice().getTotal())
                            .currency(offer.getPrice().getCurrency())
                            .build())
                    .collect(Collectors.toList());

        } catch (ResponseException e) {
            throw new RuntimeException("Error fetching flights from Amadeus", e);
        }
    }
}
