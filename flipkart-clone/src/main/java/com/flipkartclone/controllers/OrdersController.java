package com.flipkartclone.controllers;

import com.flipkartclone.dtos.UsersDto;
import com.flipkartclone.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    private final OrdersService ordersService;


    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return null;
    }


}

class OrderResponse {
    private long orderId;

    private List<UsersDto> users;
}

