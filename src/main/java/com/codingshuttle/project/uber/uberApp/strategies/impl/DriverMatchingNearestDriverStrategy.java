package com.codingshuttle.project.uber.uberApp.strategies.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.codingshuttle.project.uber.uberApp.entities.Driver;
import com.codingshuttle.project.uber.uberApp.entities.RideRequest;
import com.codingshuttle.project.uber.uberApp.repositories.DriverRepository;
import com.codingshuttle.project.uber.uberApp.strategies.DriverMatchingStrategy;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

	private final DriverRepository driverRepository;
	
	@Override
	public List<Driver> findMatchingDriver(RideRequest rideRequest) {
		return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
	}

}
