package org.tu_dresden.internal.app.datamodel;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {

	@EmbeddedId 
	@JsonIgnore
	private OrderProductPK pk;
	
	@Column(nullable = false) private Integer quantity;
}
