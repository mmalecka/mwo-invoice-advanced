package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products; 
	
	public Invoice(){
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}

	public void addProduct(Product product, Integer quantity) throws IllegalArgumentException {
		if (quantity <= 0){
			throw new IllegalArgumentException ("blad");
		}
		
		for(int i =0;i<quantity;i++){
			products.add(product);
		}
	}

	public BigDecimal getSubtotal() {
		BigDecimal sum = BigDecimal.ZERO;
		for(Product product : products){
			sum = sum.add(product.getPrice());
		}
		
		return sum;
	}

	public BigDecimal getTax() {
		BigDecimal sum = BigDecimal.ZERO;
		for(Product product : products){
			sum = sum.add(product.getPriceWithTax().subtract(product.getPrice()));
		}
		
		return sum;
	}

	public BigDecimal getTotal() {
		BigDecimal sum = BigDecimal.ZERO;
		for(Product product : products){
			sum = sum.add(product.getPriceWithTax());
		}
		
		return sum;
	}
}
