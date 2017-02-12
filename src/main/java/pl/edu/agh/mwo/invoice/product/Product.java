package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) throws IllegalArgumentException {
		if (name=="" || name==null || price==null ||(price.compareTo(BigDecimal.ZERO)==-1)){
			throw new IllegalArgumentException ("blad");
		}
		
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}
	
	

	public String getName() {
		return this.name;
		
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return price.multiply(taxPercent.add(new BigDecimal(1)));
	}
}
