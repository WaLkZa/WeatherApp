package com.example.weatherapi.service;

import com.example.weatherapi.model.dto.LocationShortResponse;

public interface LocationService {

    LocationShortResponse update(String location, Double temp);
}
