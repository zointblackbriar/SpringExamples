package org.tu_dresden.de.internal.repository;

import org.springframework.data.repository.CrudRepository;
import org.tu_dresden.internal.app.datamodel.OrderProduct;
import org.tu_dresden.internal.app.datamodel.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK>{
	
}
