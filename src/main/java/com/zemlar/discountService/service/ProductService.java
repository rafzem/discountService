package com.zemlar.discountService.service;

import com.zemlar.discountService.data.repository.ProductRepository;
import com.zemlar.discountService.service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Optional<Product> getProduct(UUID uuid)
    {
        return productRepository.getProductByUUID(uuid);
    }

}
