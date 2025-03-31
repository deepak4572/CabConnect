package com.codingshuttle.project.uber.uberApp.repositories;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingshuttle.project.uber.uberApp.entities.Driver;
import com.codingshuttle.project.uber.uberApp.entities.User;

//@Repository
//public interface DriverRepository extends JpaRepository<Driver, Long> {
////	@Query("Select d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " + "FROM drivers d "
////			+ "where d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) "
////			+ "ORDER BY distance " + "LIMIT 10",nativeQuery = true)
//
//	@Query("SELECT TOP 10 " + "d.*, " + "d.current_location.STDistance(:pickupLocation) AS distance "
//			+ "FROM drivers d " + "WHERE d.available = 1 "
//			+ "AND d.current_location.STDistance(@pickupLocation) <= 10000 " + "ORDER BY distance;")
//	List<Driver> findTenNearestDrivers(Point pickupLocation);
//
//}
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	@Query(value = "SELECT TOP 10 " + "d.*, " + "d.current_location.STDistance(:pickupLocation) AS distance "
			+ "FROM app_driver_deepak d " + "WHERE d.available = 1 "
			+ "AND d.current_location.STDistance(:pickupLocation) <= 10000 " + "ORDER BY distance", nativeQuery = true)
	List<Driver> findTenNearestDrivers(@Param("pickupLocation") Point pickupLocation);

//    @Query(value = "SELECT d.* " + 
//    "FROM drivers d " +
//    		"WHERE d.available = true AND ST_DWithin(d.current_loation, :pickupLocation, 15000) "
//    + "ORDER BY d.rating DESC "
//    + "LIMIT 10", nativeQuery = true)
//    List<Driver> findTenNearbyTopRatedDrivers(Point pickupLocation);

	@Query(value = "SELECT TOP 10 d.* " + "FROM app_driver_deepak d " + "WHERE d.available = 1 "
			+ "  AND d.current_location.STDistance(:pickupLocation) <= 15000 "
			+ "ORDER BY d.rating DESC", nativeQuery = true)
	List<Driver> findTenNearbyTopRatedDrivers(@Param("pickupLocation") Point pickupLocation);

	Optional<Driver> findByUser(User user);

}
