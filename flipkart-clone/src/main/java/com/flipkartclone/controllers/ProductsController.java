package com.flipkartclone.controllers;

import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.entities.Products;
import com.flipkartclone.service.ProductService;
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

    @PostMapping("/addProductToUserSelection")
    public String addProductToUserSelection(@RequestParam(value = "productId") int id,
                                            @RequestParam(value = "userId") int userId) {
        productService.addProductToUserSelection(id, userId);
        return String.format("Product with id {} added succesfully to user {}", id, userId);
    }

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody ProductsDto products) {
        Products savedProduct = productService.addProduct(products);
        return savedProduct;
    }

    @GetMapping("/getAllProducts")
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }



}
