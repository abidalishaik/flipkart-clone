package com.flipkartclone.dtos;

import com.flipkartclone.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

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
