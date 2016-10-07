package com.interview.cash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 * Created by dshue1 on 10/7/16.
 */
public class CashRegister {
	public static void main(String[] args) {
		String fileName = args[0];
		PriceCalculator pc = new PriceCalculator();

		Map<Merchandise, Integer> goods = new LinkedHashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			final AtomicBoolean firstLine = new AtomicBoolean(true);
			stream.forEach(line ->{
				if (firstLine.get()) {
					firstLine.set(false);
					return;
				}
				String[] params = line.split(",");
				int num = Integer.valueOf(params[0]);
				String name = params[1];
				double price = Double.valueOf(params[2]);
				Origin origin = Origin.valueOf(params[3]);
				Category category = Category.valueOf(params[4]);
				Merchandise merchandise;
				if (params.length == 5) {
					merchandise = new Merchandise(name, price, origin, category);
				}
				else if (params.length == 6) {
					String unit = params[5];
					merchandise = new Merchandise(name, price, origin, category, unit);
				}
				else {
					System.out.println("invalid line: " + line);
					return;
				}
				goods.put(merchandise, num);
			});

			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Receipt receipt = pc.calculate(goods);

		System.out.println(receipt);

	}
}
