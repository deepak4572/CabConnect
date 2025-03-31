package com.codingshuttle.project.uber.uberApp.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionMethod;
import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_wallet_transaction_deepak", indexes = {
		@Index(name = "idx_wallet_transaction_wallet", columnList = "wallet_id"),
		@Index(name = "idx_wallet_transaction_ride", columnList = "ride_id")
})
public class WalletTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	private TransactionType transactionType;
	
	private TransactionMethod transactionMethod;
	
	@ManyToOne
	private Ride ride;
	
	private String transactionId; 
	
	@ManyToOne
	private Wallet wallet;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
}
