package com.flipkartclone.services;

import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.entities.Products;
import com.flipkartclone.repositories.ProductRepository;
import com.flipkartclone.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Products addProduct(ProductsDto products) {
        Products product = new Products().builder()
                .productName(products.getProductName())
                .productDescription(products.getProductDescription())
                .build();

        Products savedProduct = productRepository.save(product);

        return savedProduct;
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
