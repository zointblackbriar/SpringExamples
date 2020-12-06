package org.tu_dresden.de.internal.repository;

import org.springframework.data.repository.CrudRepository;
import org.tu_dresden.internal.app.datamodel.Order;

public interface OrderRepository extends CrudRepository<Order, Long> { //Not Product it is an Order

}
