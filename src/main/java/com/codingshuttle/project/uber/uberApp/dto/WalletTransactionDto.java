package com.codingshuttle.project.uber.uberApp.dto;

import java.time.LocalDateTime;

import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionMethod;
import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletTransactionDto {
	private Long id;
	private Double amount;
	private TransactionType transactionType;
	private TransactionMethod transactionMethod;
	private RideDto ride;
	private String transactionId;
	private WalletDto wallet;
	private LocalDateTime timestamp;
}
