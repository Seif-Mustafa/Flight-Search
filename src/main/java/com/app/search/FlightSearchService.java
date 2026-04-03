package com.app.search;

import com.app.amadeus.FlightOfferDto;
import java.util.List;

public interface FlightSearchService {
    List<FlightOfferDto> searchFlights(String origin, String destination, String departureDate);
}
