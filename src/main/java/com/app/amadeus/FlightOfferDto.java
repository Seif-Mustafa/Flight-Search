package com.app.amadeus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightOfferDto {
    private String price;
    private String currency;
}
