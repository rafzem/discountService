package com.zemlar.discountService.service;

import com.zemlar.discountService.data.repository.DiscountRepository;
import com.zemlar.discountService.service.domain.Offer;
import com.zemlar.discountService.service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;


    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Offer calculateDiscountForProduct(Product product, int amount) {

        return discountRepository.getDiscountsForProduct(product.uuid())
                .stream()
                .map(discount -> discount.calculateDiscount(product.basePrice(), amount))
                .min(Comparator.naturalOrder())
                .map(price -> new Offer(product, price, amount))
                .orElse(new Offer(product, product.basePrice(), amount));
    }
}
