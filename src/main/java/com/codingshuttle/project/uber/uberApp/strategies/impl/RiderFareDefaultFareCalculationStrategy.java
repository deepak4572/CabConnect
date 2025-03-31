package com.codingshuttle.project.uber.uberApp.strategies.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.codingshuttle.project.uber.uberApp.entities.RideRequest;
import com.codingshuttle.project.uber.uberApp.services.DistanceService;
import com.codingshuttle.project.uber.uberApp.strategies.RideFareCalculationStrategy;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

	private final DistanceService distanceService;

	@Override
	public double calculateFare(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		double distance = distanceService
				.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
		return distance*RIDE_FARE_MULTIPLIER;
	}

}
