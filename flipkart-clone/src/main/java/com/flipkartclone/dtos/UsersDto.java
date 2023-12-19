package com.flipkartclone.dtos;

import com.flipkartclone.entities.Cart;
import com.flipkartclone.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {
    private long userId;
    private String userName;
    private String password;

    private OrdersDto order;

    private CartDto cart;


}
