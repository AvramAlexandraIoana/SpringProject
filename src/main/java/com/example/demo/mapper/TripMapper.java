package com.example.demo.mapper;

import com.example.demo.dto.LocationRequest;
import com.example.demo.dto.TripRequest;
import com.example.demo.model.Location;
import com.example.demo.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    public Trip tripRequestToTrip(TripRequest tripRequest) {
        return new Trip(tripRequest.getName(), tripRequest.getPrice(), tripRequest.getNumberOfSeats(),
                        tripRequest.getDuration(), tripRequest.getAgencyId(), tripRequest.getLocationId());
    }
}
