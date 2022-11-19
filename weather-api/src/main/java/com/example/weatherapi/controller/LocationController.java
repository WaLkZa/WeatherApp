package com.example.weatherapi.controller;

import com.example.weatherapi.model.dto.LocationShortResponse;
import com.example.weatherapi.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PutMapping("/{location}/{temp}")
    public ResponseEntity<LocationShortResponse> updateAverageTemperature(@PathVariable("location") String location,
                                                             @PathVariable("temp") Double temp) {

        LocationShortResponse updatedLocation = null;
        int retries = 0;

        // while (updatedLocation == null && retries < 5) {
        while (updatedLocation == null) {
            try {
                updatedLocation = this.locationService.update(location, temp);
            } catch (Exception e) {
                retries++;
            }
        }

        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }
}
