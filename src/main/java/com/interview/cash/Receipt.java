package com.interview.cash;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dshue1 on 10/6/16.
 */
public class Receipt {
	private List<ReceiptItem> items = new ArrayList<>();
	private BigDecimal tax;
	private BigDecimal total;

	public List<ReceiptItem> getItems() {
		return items;
	}

	public void setItems(List<ReceiptItem> items) {
		this.items = items;
	}

	public void addItem(ReceiptItem item) {
		items.add(item);
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		items.forEach(item -> sb.append(item.toString()).append("\n"));
		sb.append("--------------------------------------------------\n");
		sb.append("Sales Taxes:\t\t" + tax).append("\n");
		sb.append("Total:\t\t\t\t" + total);

		return sb.toString();
	}
}
