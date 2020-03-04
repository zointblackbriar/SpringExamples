package org.tu_dresden.internal.app.datamodel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity //Each class is an entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Product name is required")
	@Basic(optional=false)
	private String name;
	
	private Double price;
	
	private String imageUrl;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Product (Long id, @NotNull(message = "Product name is required") String name, Double price, String imageUrl) {
		this.id = id; 
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public Product() {
		
	}
}
