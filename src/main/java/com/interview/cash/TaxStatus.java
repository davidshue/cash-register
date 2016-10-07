package com.interview.cash;

import java.math.BigDecimal;

/**
 * Created by dshue1 on 10/6/16.
 */
public enum TaxStatus {
	non_exempt(.10),
	exempt;

	private BigDecimal taxRate = BigDecimal.ZERO;

	TaxStatus() {}

	TaxStatus(double taxRate) {
		this.taxRate = BigDecimal.valueOf(taxRate);
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}
}
