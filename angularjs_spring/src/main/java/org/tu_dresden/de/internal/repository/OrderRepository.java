package org.tu_dresden.de.internal.repository;

import org.springframework.data.repository.CrudRepository;
import org.tu_dresden.internal.app.datamodel.Product;

public interface OrderRepository extends CrudRepository<Product, Long> {

}
