package org.tu_dresden.internal.app.datamodel;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {

	@EmbeddedId 
	@JsonIgnore
	private OrderProductPK pk;
	
	@Column(nullable = false) private Integer quantity; //Column name should be quantity
	
	public OrderProduct() {
		super();
	}
	
	public OrderProduct(Order order, Product product, Integer quantity) //second constructor
	{
		pk = new OrderProductPK();
		pk.setOrder(order);
		pk.setProduct(product);
		this.quantity = quantity;
	}
	
	@Transient
	public Product getProduct() {
		return this.pk.getProduct();
	}
	
	@Transient
	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}
	
	public OrderProductPK getPK() {
		return pk;
		
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer paramQuantity) {
		this.quantity = paramQuantity;
	}
	
	@Override 
	public int hashCode()  //Is it necessary
	{
		final int prime = 31;
		int result = 1; 
		return result = prime  * result + ((pk == null) ? 0 : pk.hashCode());
	}
	
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        OrderProduct other = (OrderProduct) obj;
//        if (pk == null) {
//            if (other.pk != null) {
//                return false;
//            }
//        } else if (!pk.equals(other.pk)) {
//            return false;
//        }
//
//        return true;
//    }
}
