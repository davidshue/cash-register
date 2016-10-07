package com.interview.cash;

/**
 * Created by dshue1 on 10/6/16.
 */
public enum Category {
	book(TaxStatus.exempt),
	grocery(TaxStatus.exempt),
	medical(TaxStatus.exempt),
	other;

	private TaxStatus taxStatus = TaxStatus.non_exempt;

	Category() {}

	Category(TaxStatus taxStatus) {
		this.taxStatus = taxStatus;
	}

	public TaxStatus getTaxStatus() {
		return taxStatus;
	}
}
