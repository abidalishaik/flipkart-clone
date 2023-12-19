package com.flipkartclone.controllers;

import com.flipkartclone.dtos.CartDto;
import com.flipkartclone.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartContoller {

    private final CartService cartService;

    @Autowired
    public CartContoller(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addProductToCart")
    public ResponseEntity<CartDto> addProductToCart(@RequestParam("productId") int productId, @RequestParam("userId") int userId) {
        return new ResponseEntity<>(cartService.addProductToCart(productId, userId), HttpStatus.OK);
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<CartDto>> getAllCarts() {
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }
}
