package com.codingshuttle.project.uber.uberApp.strategies;

import java.util.List;

import com.codingshuttle.project.uber.uberApp.entities.Driver;
import com.codingshuttle.project.uber.uberApp.entities.RideRequest;

public interface DriverMatchingStrategy {
	List<Driver> findMatchingDriver(RideRequest rideRequest);
}
