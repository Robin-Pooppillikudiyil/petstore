package com.cloud.petstore.controller;


import com.cloud.petstore.common.ResponseData;
import com.cloud.petstore.data.OrderData;
import com.cloud.petstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Place an order for a pet

    @PostMapping("/order")
    public ResponseEntity<OrderData> createUser(@RequestBody OrderData order) {
        OrderData saveOrder = orderService.saveOrder(order);
        return new ResponseEntity(saveOrder, HttpStatus.CREATED);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderData> findByPurchaseOrderById(@PathVariable Long orderId) {
        if (orderId != null) {
            Optional<OrderData> order = orderService.findOrderByOrderId(orderId);
            if (order.isPresent()) {
                return new ResponseEntity(order, HttpStatus.FOUND);
            }
        } else {
            return new ResponseEntity("Invalid ID supplied", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Order not found\n", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<ResponseData> deleteOrder(@PathVariable Long orderId) {
        ResponseData responseData = orderService.deleteOrderByOrderId(orderId);
        return new ResponseEntity(responseData, HttpStatus.valueOf(responseData.getCode()));

    }

}
