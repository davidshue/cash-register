package com.interview.cash;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Created by dshue1 on 10/6/16.
 */
public class PriceCalculator {
	private static final BigDecimal PRECISION = BigDecimal.valueOf(0.05);

	public Receipt calculate(Map<Merchandise, Integer> goods) {
		final Receipt receipt = new Receipt();
		receipt.setTax(BigDecimal.ZERO);
		receipt.setTotal(BigDecimal.ZERO);

		goods.forEach((merchandise, num) -> _calculate(receipt, merchandise, num));
		return receipt;
	}

	private void _calculate(Receipt receipt, Merchandise merchandise, Integer number) {
		BigDecimal price = merchandise.getPrice().multiply(BigDecimal.valueOf(number));
		BigDecimal tax = BigDecimal.ZERO;
		tax = tax.add(roundTax(price.multiply(merchandise.getOrigin().getTaxRate())));

		tax = tax.add(roundTax(price.multiply(merchandise.getCategory().getTaxStatus().getTaxRate())));

		BigDecimal cost = price.add(tax);

		receipt.addItem(new ReceiptItem(number, merchandise, cost));
		receipt.setTotal(receipt.getTotal().add(cost));
		receipt.setTax(receipt.getTax().add(tax));
	}


	private BigDecimal roundTax(BigDecimal tax) {
		return tax.divide(PRECISION, 0, RoundingMode.UP).multiply(PRECISION);
	}
}
