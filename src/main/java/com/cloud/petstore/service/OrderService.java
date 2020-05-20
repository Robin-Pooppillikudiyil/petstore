package com.cloud.petstore.service;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.OrderData;

import java.util.Optional;

public interface OrderService {

    //User findInventory();

    OrderData saveOrder(OrderData order);

    Optional<OrderData> findOrderByOrderId(Long orderId);

    ResponseData deleteOrderByOrderId(Long orderId);
}
