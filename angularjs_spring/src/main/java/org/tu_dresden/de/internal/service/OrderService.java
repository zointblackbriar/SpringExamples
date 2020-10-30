package org.tu_dresden.de.internal.service;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.tu_dresden.internal.app.datamodel.Order;

// Custom annotation
@Validated
public interface OrderService {
	@NotNull Iterable<Order> getAllOrders();
	
	//create function
	Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);
	
	//update function
	void update(@NotNull(message = "The order cannot be null. ") @Valid Order order);
}
