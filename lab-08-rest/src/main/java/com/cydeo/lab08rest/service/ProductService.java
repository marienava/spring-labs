package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> retrieveProductList();

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> retrieveProductListByCategoryListAndPrice(List<Long> categoryList, BigDecimal price);

    ProductDTO retrieveByName(String name);

    List<ProductDTO> retrieveTop3Product();

    Integer retriveByPrice(BigDecimal price);

    List<ProductDTO> retrieveProductListByPriceAndQuantity(BigDecimal price, Integer quantity);

    List<ProductDTO> retrieveByCategory(Long categoryId);
}
