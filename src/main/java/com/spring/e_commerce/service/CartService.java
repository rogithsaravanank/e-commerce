package com.spring.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.e_commerce.entity.Cart;
import com.spring.e_commerce.entity.CartItem;
import com.spring.e_commerce.entity.Product;
import com.spring.e_commerce.repo.CartItemsRepo;
import com.spring.e_commerce.repo.CartRepo;
import com.spring.e_commerce.repo.ProductRepo;

@Service
public class CartService {
    
    @Autowired
    CartRepo cartRepo;

    @Autowired
    CartItemsRepo cartItemsRepo;
    
    @Autowired
    ProductRepo productRepo;

    public Cart addProductToCart(Cart cart) {
    Cart savedCart=cartRepo.save(cart);

        for (CartItem item : cart.getCartItems()) {
        // Associate the CartItem with the saved Cart

        Optional<Product> productOpt = productRepo.findById(item.getProduct().getId());

            if (!productOpt.isPresent()) {
                throw new IllegalStateException("Product with ID " + item.getProduct().getId() + " does not exist.");
            }

            // Set the product and associate the CartItem with the saved Cart
            item.setProduct(productOpt.get());
           
            
        item.setCart(savedCart);

        // Save each CartItem
        cartItemsRepo.save(item);
        }

       return savedCart;
    }

    public List<Cart> getProductFromCart() {
        return cartRepo.findAll();
    }

    public void updateProductToCart(Integer qty, Long itemId) {
        Optional<CartItem> cartItem=cartItemsRepo.findById(itemId);

        if (!cartItem.isPresent()) {
            throw new IllegalStateException("CartItem with ID does not exist.");
        }

        CartItem existingCartItem = cartItem.get();

        existingCartItem.setQuantity(qty);

        cartItemsRepo.save(existingCartItem);
    }

    public void deleteProductToCart(Long itemId) {
        Optional<CartItem> cartItem=cartItemsRepo.findById(itemId);
        if(!cartItem.isPresent()){ throw new IllegalStateException("CartItem with ID does not exist.");}

        CartItem cartItem2=cartItem.get();

        cartItemsRepo.delete(cartItem2);
    }
    
}
