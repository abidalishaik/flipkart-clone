package com.flipkartclone.dtos;

import com.flipkartclone.entities.Orders;
import com.flipkartclone.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsDto {

    private long productId;
    
    private String productName;

    private String productDescription;

    @Lob
    private byte[] productImage;

    private List<UsersDto> users;

    private Orders orderId;

}
