package com.cydeo.controller;

import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public String getAllProducts(Model model) {

        model.addAttribute("products", productService.listProduct());

        return "/product/list";
    }

    @GetMapping("/create-form")
    public String getForm(Model model) {

        model.addAttribute("product", new Product());

        return "/product/create-product";

    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product) {

        productService.productCreate(product);

        return "redirect:/list";
    }
}