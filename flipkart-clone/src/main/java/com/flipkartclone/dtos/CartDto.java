package com.flipkartclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private long cartId;

    private UsersDto user;

    private List<ProductsDto> products;
}
