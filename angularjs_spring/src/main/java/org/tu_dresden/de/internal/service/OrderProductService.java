package org.tu_dresden.de.internal.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.tu_dresden.internal.app.datamodel.OrderProduct;

public interface OrderProductService {

	OrderProduct create(@NotNull(message = "The products for order cannot be null.")@Valid OrderProduct orderProduct);
}
