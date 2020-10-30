package org.tu_dresden.de.internal.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.tu_dresden.de.internal.exceptions.ResourceNotFoundException;
import org.tu_dresden.de.internal.repository.ProductRepository;
import org.tu_dresden.internal.app.datamodel.Product;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public @NotNull Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(@Min(value = 1, message = "Invalid Product ID.") long id) {
		// TODO Auto-generated method stub
		//Resource not found is a special type of exception
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
