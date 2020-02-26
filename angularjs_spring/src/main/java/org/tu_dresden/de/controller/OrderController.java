package org.tu_dresden.de.controller;
import org.tu_dresden.de.internal.dto.OrderProductDto;

public class OrderController {

	@RestController
	@RequestMapping("/api/orders")
	public class OrderController {
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
			List<OrderProductDto> objectDTO = form.getProductOrders();
		}
	}
}
