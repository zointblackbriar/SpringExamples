package org.tu_dresden.de.internal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tu_dresden.de.internal.repository.OrderProductRepository;
import org.tu_dresden.internal.app.datamodel.OrderProduct;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService{

	private OrderProductRepository orderProductRepository;
	
	//constructor
	public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}
	
	@Override
	public OrderProduct create(OrderProduct orderProduct) {
		// TODO Auto-generated method stub
		return this.orderProductRepository.save(orderProduct);
	}
	
	
}
