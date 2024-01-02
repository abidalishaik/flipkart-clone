package com.flipkartclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsDto {

    private long productId;
    private String productName;
    private String productDescription;

    private OrdersDto order;

    private CartDto cartDto;

}
