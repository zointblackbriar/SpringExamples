package org.tu_dresden.de.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tu_dresden.de.internal.service.ProductService;
import org.tu_dresden.internal.app.datamodel.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
		private ProductService productService;
		
		public ProductController(ProductService productService) {
			this.productService = productService;
		}
		
		@GetMapping(value = {"", "/"})
		public @NotNull Iterable<Product> getProducts()
		{
			return productService.getAllProducts();
			
	}
}
