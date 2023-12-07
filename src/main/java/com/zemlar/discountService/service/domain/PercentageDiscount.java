package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class PercentageDiscount implements Discount {

    private final static BigDecimal divider = BigDecimal.valueOf(100);
    private final static int scale = 2;
    private final BigDecimal discountValue;

    public PercentageDiscount(BigDecimal discountValue) {
        this.discountValue = Optional.ofNullable(discountValue)
                .map(BigDecimal::abs)
                .orElseThrow(() -> new IllegalStateException("Discount value must not be null"));
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal basePrice, int productAmount) {

        if (productAmount <= 0) {
            throw new IllegalArgumentException("Product amount should be grater than 0");
        }

        var discountFactor = calculateDiscountFactor(discountValue);

        return Optional.ofNullable(basePrice)
                .map(price -> price.multiply(BigDecimal.valueOf(productAmount)))
                .map(price -> price.multiply(discountFactor))
                .orElseThrow(() -> new IllegalArgumentException("Base price can't be null"));
    }


    private BigDecimal calculateDiscountFactor(BigDecimal value) {
        return divider.subtract(value).divide(divider, scale, RoundingMode.FLOOR);
    }
}
