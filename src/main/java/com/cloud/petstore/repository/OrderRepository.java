package com.cloud.petstore.repository;

import com.cloud.petstore.data.OrderData;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderData, Long> {

}
