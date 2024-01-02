package com.flipkartclone.services;

import com.flipkartclone.dtos.CartDto;
import com.flipkartclone.dtos.ProductsDto;
import com.flipkartclone.dtos.UsersDto;
import com.flipkartclone.entities.Cart;
import com.flipkartclone.entities.Products;
import com.flipkartclone.entities.Users;
import com.flipkartclone.repositories.CartRepository;
import com.flipkartclone.repositories.ProductRepository;
import com.flipkartclone.repositories.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, UsersRepository usersRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public CartDto addProductToCart(int productId, int userId) {
//        get the product
        Products product = productRepository.findById((long) productId)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("Product not found with id {}", productId)));
//        conversion to dto
        ProductsDto productDto = modelMapper.map(product, ProductsDto.class);

//        get the user
        Users user = usersRepository.findById((long) userId)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format("User not found with id {}", userId)));
//        conversion to dto
        UsersDto userDto = modelMapper.map(user, UsersDto.class);

//        get the cart id by of the user
        long cartId = userDto.getCart().getCartId();

//        get the cart
        Cart cart = cartRepository.findById(cartId).get();

//        conversion to dto
        CartDto cartDto = modelMapper.map(cart, CartDto.class);
//        add the product to cart
        List<ProductsDto> products = cartDto.getProducts();
        products.add(productDto);
        cartDto.setProducts(products);

//        conversion to POJO
        Cart saveCart = modelMapper.map(cartDto, Cart.class);

//        save the cart
        Cart savedCart = cartRepository.save(saveCart);

        return modelMapper.map(savedCart, CartDto.class);
    }

    public List<CartDto> getAllCarts() {
        List<Cart> allCarts = cartRepository.findAll();
        return allCarts.stream().map(v -> modelMapper.map(v, CartDto.class)).toList();
    }
}
