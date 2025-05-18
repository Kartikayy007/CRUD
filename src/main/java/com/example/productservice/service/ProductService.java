package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import java.util.List;

public interface ProductService {
    
    ProductDto createProduct(ProductDto productDto);
    
    ProductDto getProductById(Long id);
    
    List<ProductDto> getAllProducts();
    
    ProductDto updateProduct(Long id, ProductDto productDto);
    
    void deleteProduct(Long id);
    
    List<ProductDto> searchProductsByName(String name);
    
    List<ProductDto> getActiveProducts();
}
