package org.tu_dresden.de.internal.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.tu_dresden.internal.app.datamodel.Product;

public interface ProductService {
	
	@NotNull Iterable<Product> getAllProducts();
	
	Product getProduct(@Min(value = 1L, message = "Invalid Product ID.") long id);
	
	Product save(Product product);
	
}
