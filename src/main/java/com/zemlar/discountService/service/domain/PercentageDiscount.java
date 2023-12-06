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
    public BigDecimal calculateDiscount(BigDecimal basePrice) {

        BigDecimal discount = Optional.ofNullable(basePrice)
                .map(price -> price.divide(divider, scale, RoundingMode.FLOOR))
                .map(price -> price.multiply(discountValue))
                .orElseThrow(() -> new IllegalArgumentException("Base price can't be null"));


        return basePrice.subtract(discount);
    }
}
