package com.interview.cash;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by dshue1 on 10/6/16.
 */
public class ReceiptItem {
	private int number;
	private Merchandise merchandise;
	private BigDecimal cost;

	public ReceiptItem(int number, Merchandise merchandise, BigDecimal cost) {
		this.number = number;
		this.merchandise = merchandise;
		this.cost = cost;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}


	@Override
	public String toString() {
		if (StringUtils.isBlank(merchandise.getUnit())) {
			return number + "\t\t\t" + merchandise + ":\t\t" + cost;
		}
		else {
			return number + " " + merchandise.getUnit() + "(s) \t" + merchandise + ":\t\t" + cost;
		}
	}

}
