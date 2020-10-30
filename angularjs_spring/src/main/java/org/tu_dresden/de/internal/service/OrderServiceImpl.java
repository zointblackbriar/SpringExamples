package org.tu_dresden.de.internal.service;

import java.time.LocalDate;

import org.tu_dresden.de.internal.repository.OrderProductRepository;
import org.tu_dresden.internal.app.datamodel.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private OrderProductRepository orderRepository;
	
	public OrderServiceImpl(OrderProductRepository orderProductRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Iterable<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}
	
	@Override
	public Order create(Order order) {
		order.setDateCreated(LocalDate.now());
		
		return this.orderRepository.save(order);
	}
	
	@Override
	public void update(Order order) {
		this.orderRepository.save(order);
	}
	
	
}
