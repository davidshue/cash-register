package com.interview.cash;

import java.math.BigDecimal;

/**
 * Created by dshue1 on 10/6/16.
 */
public enum Origin {
	domestic,
	imported(0.05);

	private BigDecimal taxRate = BigDecimal.valueOf(0.0);

	Origin() {}
	Origin(double taxRate) {
		this.taxRate = BigDecimal.valueOf(taxRate);
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}
}