package org.tu_dresden.internal.app.datamodel;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="order")
//This should be a serializable class
public class OrderProductPK implements Serializable{
	private static final long serialVersionID = 1L;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//Hashcode Function
	//Object comparison function
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		OrderProductPK orderpk = (OrderProductPK) obj;
		if(order == null) {
			if(orderpk.order != null) {
				return false;
			}
		} else if(!order.equals(orderpk.order)) {
			return false;
		}
		
		return true;
	}
	
}
