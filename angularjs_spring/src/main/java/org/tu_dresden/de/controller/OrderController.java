package org.tu_dresden.de.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.tu_dresden.de.internal.dto.OrderProductDTO;
import org.tu_dresden.de.internal.exceptions.ResourceNotFoundException;
import org.tu_dresden.de.internal.service.OrderProductService;
import org.tu_dresden.de.internal.service.OrderService;
import org.tu_dresden.de.internal.service.ProductService;
import org.tu_dresden.internal.app.datamodel.Order;
import org.tu_dresden.internal.app.datamodel.OrderProduct;
import org.tu_dresden.internal.app.datamodel.OrderStatus;
import org.tu_dresden.de.internal.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;


@RestController
@RequestMapping("/api/orders")  //this is the URI address
public class OrderController {
		private Logger logger = LoggerFactory.getLogger(OrderController.class.getName());

		ProductService productService;  //coming from DTO
		OrderService orderService;
		OrderProductService orderProductService;
		
		public OrderController (ProductService productService, OrderService orderService, OrderProductService orderProductService){
			this.productService = productService;
			this.orderService = orderService;
			this.orderProductService = orderProductService;
		}
		
		//Response Entity
		@PostMapping
		public ResponseEntity<Order> create(@RequestBody OrderForm form) {
			List<OrderProductDTO> objectDTO = form.getProductOrders();
			productExistance(objectDTO);
			Order order = new Order();
			order.setStatus(OrderStatus.PAID.name()); // assign a status for OrderStatus
			order = this.orderService.create(order);
			
			List<OrderProduct> orderProducts = new ArrayList<>();
			for (OrderProductDTO dto : objectDTO) {
	            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
	                    .getProduct()
	                    .getId()), dto.getQuantity())));
			}
			
			order.setOrderProducts(orderProducts); //setting the product
			
			this.orderService.update(order);
			
			String uri = ServletUriComponentsBuilder
					.fromCurrentServletMapping()
					.path("/orders/{id}")
					.buildAndExpand(order.getId())
					.toString();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Location", uri);  //how many headers can we add?
			
			return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
		}
		
		@GetMapping
		@ResponseStatus(HttpStatus.OK) 
		public @NotNull Iterable<Order> list() {
			return this.orderService.getAllOrders();
		}
				
		public static class OrderForm {
			private List<OrderProductDTO> productOrders;
			
			public List<OrderProductDTO> getProductOrders() {
				return productOrders;
			}
			
			public void setProductOrders(List<OrderProductDTO>productOrders) {
				
			}
		}
		
	private void productExistance(List<OrderProductDTO> orderProducts) {
		// Create a list that will check to order product
		List<OrderProductDTO> listOrderProducts = orderProducts
				.stream()
				.filter(operand -> Objects.isNull(productService.getProduct(operand.getProduct().getId())))
				.collect(Collectors.toList());
		
		if(!CollectionUtils.isEmpty(listOrderProducts)) {
			logger.info("Product could not found");
			new ResourceNotFoundException("Product not found");
		}
	}
}
	

