package com.example.demo.mapper;

import com.example.demo.dto.AgencyRequest;
import com.example.demo.dto.LocationRequest;
import com.example.demo.model.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyMapper {
    public Agency agencyRequestToAgency(AgencyRequest agencyRequest) {
        return new Agency(agencyRequest.getName(), agencyRequest.getLocationCode());
    }
}
