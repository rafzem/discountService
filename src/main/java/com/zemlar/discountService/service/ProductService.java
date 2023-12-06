package com.zemlar.discountService.service;

import com.zemlar.discountService.data.repository.ProductRepository;
import com.zemlar.discountService.service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
