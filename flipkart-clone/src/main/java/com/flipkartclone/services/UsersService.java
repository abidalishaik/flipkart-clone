package com.flipkartclone.services;

import com.flipkartclone.dtos.CartDto;
import com.flipkartclone.dtos.UsersDto;
import com.flipkartclone.entities.Cart;
import com.flipkartclone.entities.Users;
import com.flipkartclone.repositories.CartRepository;
import com.flipkartclone.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper, CartRepository cartRepository) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.cartRepository = cartRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("resource not found"));
    }

    public Users saveUser(Users users) {
        users.setCart(new Cart());
        Users user = usersRepository.save(users);

        return user;
    }
}
