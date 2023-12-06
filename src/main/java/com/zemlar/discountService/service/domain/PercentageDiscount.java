package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class PercentageDiscount implements Discount {

    private final BigDecimal discountValue;

    private final static BigDecimal divider = BigDecimal.valueOf(100);
    private final static int scale = 2;

    public PercentageDiscount(BigDecimal discountValue) {
        this.discountValue = Optional.ofNullable(discountValue)
                .orElseThrow(() -> new IllegalStateException("Discount value must not be null"));
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal basePrice, int productAmount) {

        if (productAmount <= 0) {
            throw new IllegalArgumentException("Product amount should be grater than 0");
        }

        var discount = divider.subtract(discountValue).divide(divider, scale, RoundingMode.FLOOR);

        return Optional.ofNullable(basePrice)
                .map(price -> price.multiply(BigDecimal.valueOf(productAmount)))
                .map(price -> price.multiply(discount))
                .orElseThrow(() -> new IllegalArgumentException("Base price can't be null"));
    }
}
