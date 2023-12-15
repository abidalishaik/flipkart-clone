package com.flipkartclone.service;

import com.flipkartclone.constants.DtoConverters;
import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.dtos.UsersDto;
import com.flipkartclone.entities.Products;
import com.flipkartclone.entities.Users;
import com.flipkartclone.repositories.ProductRepository;
import com.flipkartclone.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;


    @Autowired
    public ProductService(ProductRepository productRepository, UsersRepository usersRepository) {
        this.productRepository = productRepository;
        this.usersRepository = usersRepository;
    }

    public boolean addProductToUserSelection(long id, long userId) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no Entity present in db with product id " + id));

        Users user = usersRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("no Entity present in db with product id " + userId));

        UsersDto usersDto = DtoConverters.userToUserDto(user);

        ProductsDto productsDto = DtoConverters.productToProductDto(product);
        List<UsersDto> users = productsDto.getUsers();
        users.add(usersDto);

        productsDto.setUsers(users);

        Products products = DtoConverters.productDtoToProduct(productsDto);


        productRepository.save(products);

        return true;
    }

    public Products addProduct(ProductsDto products) {
        Products product = new Products().builder()
                .productName(products.getProductName())
                .productDescription(products.getProductDescription())
                .productImage(products.getProductImage())
                .build();

        Products savedProduct = productRepository.save(product);

        return savedProduct;
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
