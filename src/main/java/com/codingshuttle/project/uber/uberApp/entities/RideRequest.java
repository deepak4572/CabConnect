package com.codingshuttle.project.uber.uberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentMethod;
import com.codingshuttle.project.uber.uberApp.entities.enums.RideRequestStatus;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_ride_request_deepak", indexes = {
		@Index(name = "idx_ride_request_rider", columnList = "rider_id")
})
public class RideRequest {
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
	private LocalDateTime requestedTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideRequestStatus rideRequestStatus;
	
	private Double fare;
}
