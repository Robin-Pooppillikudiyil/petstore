package com.cloud.petstore.serviceImpl;

import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.OrderData;
import com.cloud.petstore.repository.OrderRepository;
import com.cloud.petstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderData saveOrder(OrderData order) {
        order.setId(null);
        return orderRepository.save(order);
    }

    /*@Override
    public ResponseEntity<Order> saveOrder(Order order) {
        order.setId(null);
        orderRepository.save(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }*/

    @Override
    public Optional<OrderData> findOrderByOrderId(Long orderId) {
        //orderRepository.findById(orderId);
        return orderRepository.findById(orderId);
    }

    @Override
    public ResponseData deleteOrderByOrderId(Long orderId) {
        Optional<OrderData> dbOrder = orderRepository.findById(orderId);
        if (!dbOrder.isPresent()) {
            return new ResponseData(HttpStatus.BAD_REQUEST.value(), "unknown", "Invalid pet Id");
        }
        orderRepository.delete(dbOrder.get());
        return new ResponseData(HttpStatus.OK.value(), "unknown", orderId.toString());
    }

}
