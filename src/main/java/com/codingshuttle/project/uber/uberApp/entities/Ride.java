package com.codingshuttle.project.uber.uberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentMethod;
import com.codingshuttle.project.uber.uberApp.entities.enums.RideStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_ride_deepak", indexes = {
		@Index(name = "idx_ride_rider", columnList = "rider_id"),
		@Index(name = "idx_ride_driver", columnList = "driver_id")
})
public class Ride {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(columnDefinition = "Geometry(Point,4326)")
	@Column(columnDefinition = "geometry")
	private Point pickupLocation;
	
//	@Column(columnDefinition = "Geometry(Point,4326)")
	@Column(columnDefinition = "geometry")
	private Point dropOffLocation;
	
	@CreationTimestamp
	private LocalDateTime createdTime; // time when driver accepts your ride
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;
	
	private String otp;
	
	private Double fare;
	private LocalDateTime startedAt;	// time when driver actually starts your ride
	private LocalDateTime endedAt;
}
