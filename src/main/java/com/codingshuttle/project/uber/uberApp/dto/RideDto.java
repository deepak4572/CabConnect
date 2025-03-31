package com.codingshuttle.project.uber.uberApp.dto;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import com.codingshuttle.project.uber.uberApp.entities.Rider;
import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentMethod;
import com.codingshuttle.project.uber.uberApp.entities.enums.RideStatus;

import lombok.Data;

@Data
public class RideDto {
	private Long id;
	private PointDto pickupLocation;
	private PointDto dropOffLocation;
	private LocalDateTime createdTime;
	private RiderDto rider;
	private DriverDto driver;
	private PaymentMethod paymentMethod;
	private RideStatus rideStatus;
	
	private String otp;
	private Double fare;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
}
