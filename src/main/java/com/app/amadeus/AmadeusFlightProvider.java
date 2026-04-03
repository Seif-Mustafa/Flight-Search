package com.app.amadeus;

import java.util.List;

public interface AmadeusFlightProvider {
    List<FlightOfferDto> getFlightOffers(String origin, String destination, String departureDate);
}
