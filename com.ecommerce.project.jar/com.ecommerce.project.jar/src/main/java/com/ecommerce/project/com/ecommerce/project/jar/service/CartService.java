package com.ecommerce.project.com.ecommerce.project.jar.service;

import com.ecommerce.project.com.ecommerce.project.jar.model.Cart;
import com.ecommerce.project.com.ecommerce.project.jar.model.Customer;
import com.ecommerce.project.com.ecommerce.project.jar.model.Product;
import com.ecommerce.project.com.ecommerce.project.jar.repository.CartRepository;
import com.ecommerce.project.com.ecommerce.project.jar.repository.CustomerRepository;
import com.ecommerce.project.com.ecommerce.project.jar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }     // Get items in the cart for a specific user (you may add user-specific logic)

    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }     // Remove an item from the cart

    public void removeFromCart(Long cartItemId)
    {
        cartRepository.deleteById(cartItemId);
    }

}