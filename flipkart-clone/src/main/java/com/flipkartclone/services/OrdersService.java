package com.flipkartclone.services;

import com.flipkartclone.dtos.OrdersDto;
import com.flipkartclone.entities.Orders;
import com.flipkartclone.entities.Users;
import com.flipkartclone.repositories.OrderRepository;
import com.flipkartclone.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrdersService {

    private final OrderRepository orderRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public OrdersService(OrderRepository orderRepository, UsersRepository usersRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrdersDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(val -> modelMapper.map(val, OrdersDto.class)).toList();
    }

    public OrdersDto saveOrder(int userId) {
        Users users = usersRepository.findById((long) userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Resource not found with id {}", userId)));

        Orders orders = new Orders();
        orders.setUser(users);

        return modelMapper.map(orderRepository.save(orders), OrdersDto.class);
    }
}
