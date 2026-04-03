package com.app.search;

import com.app.amadeus.FlightOfferDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping("/search")
    public List<FlightOfferDto> search(@RequestParam String origin,
                                       @RequestParam String destination,
                                       @RequestParam String departureDate) {
        return flightSearchService.searchFlights(origin, destination, departureDate);
    }
}
