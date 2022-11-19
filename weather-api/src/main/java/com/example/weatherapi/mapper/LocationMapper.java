package com.example.weatherapi.mapper;

import com.example.weatherapi.model.dto.LocationShortResponse;
import com.example.weatherapi.model.entity.Location;

public interface LocationMapper {

    LocationShortResponse locationToLocationResponse(Location locationEntity);
}
