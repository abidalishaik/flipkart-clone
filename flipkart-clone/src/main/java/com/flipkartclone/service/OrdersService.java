package com.flipkartclone.service;

import com.flipkartclone.repositories.OrderRepository;
import com.flipkartclone.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrderRepository orderRepository;
    private final UsersRepository usersRepository;


    @Autowired
    public OrdersService(OrderRepository orderRepository, UsersRepository usersRepository) {
        this.orderRepository = orderRepository;
        this.usersRepository = usersRepository;
    }
}
