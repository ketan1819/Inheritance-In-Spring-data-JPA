package com.example.demo.repositories;

import com.example.demo.models.Booking;
import com.example.demo.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long>
{
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    List<Driver>findAllByIdIn(List<Long> driverIds);


}


