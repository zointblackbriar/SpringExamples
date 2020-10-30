package org.tu_dresden.de.internal.dto;

import org.tu_dresden.internal.app.datamodel.Product;

// Data Entity Model 
public class OrderProductDTO {
	private Product product;
	private Integer quantity;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
