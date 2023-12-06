package com.zemlar.discountService.service.domain;

import com.zemlar.discountService.mapper.MathUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class PercentageDiscount implements Discount {

    private final BigDecimal discountValue;

    public PercentageDiscount(BigDecimal discountValue) {
        this.discountValue = Optional.ofNullable(discountValue)
                .orElseThrow(() -> new IllegalStateException("Discount value must not be null"));
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal basePrice, int productAmount) {

        if (productAmount <= 0) {
            throw new IllegalArgumentException("Product amount should be grater than 0");
        }

        var discountFactor = MathUtils.calculateDiscountFactor(discountValue);

        return Optional.ofNullable(basePrice)
                .map(price -> price.multiply(BigDecimal.valueOf(productAmount)))
                .map(price -> price.multiply(discountFactor))
                .orElseThrow(() -> new IllegalArgumentException("Base price can't be null"));
    }
}
