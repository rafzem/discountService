package com.zemlar.discountService.service;

import com.zemlar.discountService.data.repository.DiscountRepository;
import com.zemlar.discountService.service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;


    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Product calculateDiscountForProduct(Product product, int amount) {

        return discountRepository.getDiscountsForProduct(product.uuid())
                .stream()
                .map(discount -> discount.calculateDiscount(product.basePrice(), amount))
                .min(Comparator.naturalOrder())
                .map(price -> new Product(product.uuid(), product.name(), price))
                .orElse(product);
    }
}
