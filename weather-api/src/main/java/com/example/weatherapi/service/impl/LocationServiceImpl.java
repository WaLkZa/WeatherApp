package com.example.weatherapi.service.impl;

import com.example.weatherapi.mapper.LocationMapper;
import com.example.weatherapi.model.dto.LocationShortResponse;
import com.example.weatherapi.model.entity.Location;
import com.example.weatherapi.repository.LocationRepository;
import com.example.weatherapi.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    @Transactional
    public LocationShortResponse update(String locationName, Double temp) {

        Optional<Location> findLocation = this.locationRepository.findByName(locationName);

        if (findLocation.isEmpty()) {
            Location newLocation = Location.builder()
                    .name(locationName)
                    .averageTemperature(temp)
                    .updateCount(1)
                    .sumAllTemperatures(temp)
                    .build();

            Location savedLocation = this.locationRepository.save(newLocation);

            return this.locationMapper.locationToLocationResponse(savedLocation);
        } else {
            Location foundLocation = findLocation.get();

            double newAvg = foundLocation.getSumAllTemperatures() / foundLocation.getUpdateCount();

            foundLocation.setAverageTemperature(newAvg);
            foundLocation.setUpdateCount(foundLocation.getUpdateCount() + 1);
            foundLocation.setSumAllTemperatures(foundLocation.getSumAllTemperatures() + temp);

            Location updatedLocation = this.locationRepository.save(foundLocation);

            return this.locationMapper.locationToLocationResponse(updatedLocation);
        }
    }
}
