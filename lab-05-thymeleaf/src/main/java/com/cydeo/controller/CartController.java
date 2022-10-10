package com.cydeo.controller;

import com.cydeo.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static com.cydeo.service.impl.CartServiceImpl.CART;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String createCart(Model model) {
        model.addAttribute("cart",CART);

        return "/cart/show-cart";
    }

    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId")UUID productId,
                            @PathVariable("quantity")Integer quantity, Model model) {

        cartService.addToCart(productId,quantity);
        model.addAttribute("cart",CART);

        return "/cart/show-cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") UUID productId, Model model) {

        cartService.deleteFromCart(productId);
        model.addAttribute("cart",CART);
        return "/cart/show-cart";
    }
}
