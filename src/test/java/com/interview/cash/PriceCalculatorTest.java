package com.interview.cash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dshue1 on 10/6/16.
 */
public class PriceCalculatorTest {
	@Test
	public void testCalculateTotal() {
		PriceCalculator pc = new PriceCalculator();
		Map<Merchandise, Integer> goods = new HashMap<>();
		Merchandise m1 = new Merchandise("lord of the rings", 29.99, Origin.domestic, Category.book);

		goods.put(m1, 2);

		Merchandise m2 = new Merchandise("sneaker", 59.99, Origin.domestic, Category.other, "pair");

		goods.put(m2, 3);

		Merchandise m3 = new Merchandise("pain killer", 12.00, Origin.imported, Category.medical, "packet");

		goods.put(m3, 1);

		Receipt receipt = pc.calculate(goods);

		System.out.println(receipt);
	}

	@Test
	public void testExemptGoods() {
		Merchandise book = new Merchandise("Bible", 29.99, Origin.domestic, Category.book);
		Merchandise grocery = new Merchandise("Celery", 2.95, Origin.domestic, Category.grocery, "pound");
		Map<Merchandise, Integer> goods = new LinkedHashMap<>();
		goods.put(book, 1);
		goods.put(grocery, 2);

		PriceCalculator pc = new PriceCalculator();
		Receipt receipt = pc.calculate(goods);

		assertEquals(35.89, receipt.getTotal().doubleValue(), 0.01);
		assertEquals(0.00, receipt.getTax().doubleValue(), 0.01);
	}

	@Test
	public void testNonExemptGoods() {
		Merchandise shirt = new Merchandise("button shirt", 29.99, Origin.domestic, Category.other);
		Merchandise macbook = new Merchandise("Macbook", 2999.95, Origin.domestic, Category.other);
		Map<Merchandise, Integer> goods = new LinkedHashMap<>();
		goods.put(shirt, 1);
		goods.put(macbook, 2);

		PriceCalculator pc = new PriceCalculator();
		Receipt receipt = pc.calculate(goods);

		assertEquals(6632.89, receipt.getTotal().doubleValue(), 0.01);
		assertEquals(603.00, receipt.getTax().doubleValue(), 0.01);
	}
}
