package org.tu_dresden.de.internal.service;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.tu_dresden.de.internal.repository.OrderProductRepository;
import org.tu_dresden.de.internal.repository.OrderRepository;
import org.tu_dresden.internal.app.datamodel.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderProductRepository orderProductRepository) {
		this.orderRepository = orderRepository;
	}
	

	@Override
	public @NotNull Iterable<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}

	@Override
	public void update(@NotNull(message = "The order cannot be null. ") @Valid Order order) {
		// TODO Auto-generated method stub
		this.orderRepository.save(order);
	}

	@Override
	public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order) {
		// TODO Auto-generated method stub
		order.setDateCreated(LocalDate.now());
		return this.orderRepository.save(order);
	}	
	
}
