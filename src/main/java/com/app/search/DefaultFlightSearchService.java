package com.app.search;

import com.app.amadeus.AmadeusFlightProvider;
import com.app.amadeus.FlightOfferDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultFlightSearchService implements FlightSearchService {

    private final AmadeusFlightProvider amadeusFlightProvider;

    public DefaultFlightSearchService(AmadeusFlightProvider amadeusFlightProvider) {
        this.amadeusFlightProvider = amadeusFlightProvider;
    }

    @Override
    public List<FlightOfferDto> searchFlights(String origin, String destination, String departureDate) {
        return amadeusFlightProvider.getFlightOffers(origin, destination, departureDate);
    }
}
