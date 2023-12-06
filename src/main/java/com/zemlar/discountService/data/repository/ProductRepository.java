package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.service.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> getProducts();

    Optional<Product> getProductByUUID(UUID uuid);
}
