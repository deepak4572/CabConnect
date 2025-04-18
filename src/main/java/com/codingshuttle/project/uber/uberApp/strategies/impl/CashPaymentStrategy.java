package com.codingshuttle.project.uber.uberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.codingshuttle.project.uber.uberApp.entities.Driver;
import com.codingshuttle.project.uber.uberApp.entities.Payment;
import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentStatus;
import com.codingshuttle.project.uber.uberApp.entities.enums.TransactionMethod;
import com.codingshuttle.project.uber.uberApp.repositories.PaymentRepository;
import com.codingshuttle.project.uber.uberApp.services.PaymentService;
import com.codingshuttle.project.uber.uberApp.services.WalletService;
import com.codingshuttle.project.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;


//Rider -> 100
//Driver -> 70 Deduct 30Rs from Driver's Wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {
	
	private final WalletService walletService;
	private final PaymentRepository paymentRepository;
	
	@Override
	public void processPayment(Payment payment) {
		Driver driver = payment.getRide().getDriver();
		
		double platformCommision = payment.getAmount() * PLATFORM_COMMISSION;
		
		walletService.deductMoneyFromWallet(driver.getUser(), platformCommision, null, payment.getRide(), TransactionMethod.RIDE);
		
		payment.setPaymentStatus(PaymentStatus.CONFIRMED);
		paymentRepository.save(payment);
	}

}
