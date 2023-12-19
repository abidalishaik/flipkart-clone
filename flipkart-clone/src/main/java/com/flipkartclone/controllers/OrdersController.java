package com.flipkartclone.controllers;

import com.flipkartclone.dtos.OrdersDto;
import com.flipkartclone.services.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    private final OrdersService ordersService;
    private final ModelMapper modelMapper;


    @Autowired
    public OrdersController(OrdersService ordersService, ModelMapper modelMapper) {
        this.ordersService = ordersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrdersDto>> getAllOrders() {
        List<OrdersDto> allOrders = ordersService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @PostMapping("/saveOrder")
    public OrdersDto saveOrder(@RequestParam("userId") int userId) {
        return ordersService.saveOrder(userId);
    }


}



