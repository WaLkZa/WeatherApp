package com.example.weatherapi.mapper.impl;

import com.example.weatherapi.mapper.LocationMapper;
import com.example.weatherapi.model.dto.LocationShortResponse;
import com.example.weatherapi.model.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationShortResponse locationToLocationResponse(Location locationEntity) {
        LocationShortResponse locationResponse = new LocationShortResponse();
        locationResponse.setAverageTemperature(locationEntity.getAverageTemperature());
        return locationResponse;
    }
}
