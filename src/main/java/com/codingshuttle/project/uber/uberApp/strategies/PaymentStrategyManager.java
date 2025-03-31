package com.codingshuttle.project.uber.uberApp.strategies;

import org.springframework.stereotype.Component;

import com.codingshuttle.project.uber.uberApp.entities.enums.PaymentMethod;
import com.codingshuttle.project.uber.uberApp.strategies.impl.CashPaymentStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.WalletPaymentStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

	private final WalletPaymentStrategy walletPaymentStrategy;
	private final CashPaymentStrategy cashPaymentStrategy;

	public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
		return switch (paymentMethod) {
		case WALLET -> walletPaymentStrategy;
		case CASH -> cashPaymentStrategy;
		};
	}
}
