package com.flipkartclone.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrdersDto {

    private long orderId;

    private List<ProductsDto> products;

    private UsersDto user;
}
