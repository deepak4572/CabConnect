package com.codingshuttle.project.uber.uberApp.strategies;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RiderFareDefaultFareCalculationStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
	
	private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
	private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
	private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
	private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
	
	public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
		if(riderRating >= 4.8) {
			return highestRatedDriverStrategy;
		} else {
			return nearestDriverStrategy;
		}
	}
	
	public RideFareCalculationStrategy rideFareCalculationStrategy() {
		// 6PM to 9PM is SURGE TIME
		LocalTime surgeStartTime = LocalTime.of(18,0);
		LocalTime surgeEndTime = LocalTime.of(21,0);
		LocalTime currentTime = LocalTime.now();
		
		boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
		
		if(isSurgeTime) {
			return surgePricingFareCalculationStrategy;
		} else {
			return defaultFareCalculationStrategy;
		}
	}
}
