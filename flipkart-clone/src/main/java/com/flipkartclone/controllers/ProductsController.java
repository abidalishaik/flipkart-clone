package com.flipkartclone.controllers;

import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.entities.Products;
import com.flipkartclone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody ProductsDto products) {
        Products savedProduct = productService.addProduct(products);
        return savedProduct;
    }

    @GetMapping("/getAllProducts")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }


}
