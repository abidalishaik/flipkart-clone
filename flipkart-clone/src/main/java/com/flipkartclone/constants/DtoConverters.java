package com.flipkartclone.constants;

import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.dtos.UsersDto;
import com.flipkartclone.entities.Products;
import com.flipkartclone.entities.Users;
import org.modelmapper.ModelMapper;

public interface DtoConverters {

    ModelMapper modelMapper = new ModelMapper();

    public static UsersDto userToUserDto(Users users) {
        return modelMapper.map(users, UsersDto.class);
    }


    public static ProductsDto productToProductDto(Products products) {
        return modelMapper.map(products, ProductsDto.class);
    }

    public static Users userDtoToUser(UsersDto usersDto) {
        return modelMapper.map(usersDto, Users.class);
    }

    public static Products productDtoToProduct(ProductsDto productsDto) {
        return modelMapper.map(productsDto, Products.class);
    }

}
