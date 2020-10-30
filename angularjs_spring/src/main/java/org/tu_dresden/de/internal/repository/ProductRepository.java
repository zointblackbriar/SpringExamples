package org.tu_dresden.de.internal.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;
import org.tu_dresden.internal.app.datamodel.Product;


@Validated
public interface ProductRepository extends CrudRepository<Product, Long> {
	
//	@NotNull Iterable<Product> getAllProducts();
//	
//	//Validation with constraints
//	Product getProduct(@Min(value = 1L, message = "Invalid Product ID. ") long id);
//	
//	Product save(Product product);
	
}
