package com.example.weatherapi.repository;

import com.example.weatherapi.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Location> findByName(String name);
}
