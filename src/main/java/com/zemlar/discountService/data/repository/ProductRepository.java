package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.service.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();
}
