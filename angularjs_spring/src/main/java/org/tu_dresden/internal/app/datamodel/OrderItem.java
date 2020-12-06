package org.tu_dresden.internal.app.datamodel;

public class OrderItem {
	
	private int productId; 
	private int quantity;
	private float unitPrice;
	private float unitWeight; 
	
	//Constructor
	public OrderItem(int productId, int quantity, float unitPrice, float unitWeight) {
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitWeight = unitWeight;
	}
	
	public int getProductId() {
		return this.productId;
	}
	
	public void setProductId(int paramProductId) {
		this.productId = paramProductId;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int paramQuantity) {
		this.quantity = paramQuantity;
	}
	
	public void setUnitPrice(float paramUnitPrice) {
		this.unitPrice = paramUnitPrice;
	}
	
	public float getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setUnitWeight(float paramUnitWeight) {
		this.unitWeight = paramUnitWeight; 
	}
	
	public float getUnitWeight() {
		return this.unitWeight;
	}
	
	public float getTotalPrice() {
		return this.quantity * this.unitPrice;
	}

}
