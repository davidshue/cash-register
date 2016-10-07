package com.interview.cash;

import java.math.BigDecimal;

/**
 * Created by dshue1 on 10/6/16.
 */
public class Merchandise {
	private String name;
	private BigDecimal price;
	private Origin origin;
	private Category category;
	private String unit;

	public Merchandise(String name, double price, Origin origin, Category category) {
		this.name = name;
		this.price = BigDecimal.valueOf(price);
		this.origin = origin;
		this.category = category;
	}

	public Merchandise(String name, double price, Origin origin, Category category, String unit) {
		this.name = name;
		this.price = BigDecimal.valueOf(price);
		this.origin = origin;
		this.category = category;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return (origin == Origin.domestic? "" : Origin.imported + " ") + name;
	}
}
