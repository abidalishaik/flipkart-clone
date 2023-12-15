package com.flipkartclone.dtos;

import com.flipkartclone.entities.Orders;
import com.flipkartclone.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {
    private long userId;
    private String userName;
    private String password;

    private List<Orders> orders;

    private List<ProductsDto> products;

}
