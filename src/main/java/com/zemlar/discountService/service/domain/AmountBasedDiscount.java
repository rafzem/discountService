package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;
import java.util.Optional;

public class AmountBasedDiscount implements Discount {

    private final int minimalProductAmount;
    private final BigDecimal baseDiscount;
    private final BigDecimal maxDiscount;
    private final BigDecimal discountStep;

    public AmountBasedDiscount(int minimalProductAmount, BigDecimal baseDiscount, BigDecimal maxDiscount, BigDecimal discountStep) {
        if (minimalProductAmount <= 0) {
            throw new IllegalStateException("Minimal discount product amount should be grater than 0");
        }
        this.minimalProductAmount = minimalProductAmount;
        this.baseDiscount = Optional.ofNullable(baseDiscount).orElseThrow(IllegalStateException::new);
        this.maxDiscount = Optional.ofNullable(maxDiscount).orElseThrow(IllegalStateException::new);
        this.discountStep = Optional.ofNullable(discountStep).orElseThrow(IllegalStateException::new);
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal basePrice, int productAmount) {

        if (productAmount <= 0) {
            throw new IllegalArgumentException("Product amount should be grater than 0");

        }
        if (productAmount < minimalProductAmount) {
            return basePrice.multiply(BigDecimal.valueOf(productAmount));
        } else {
            var discountValue = calculateDiscountValue(productAmount);
            return new PercentageDiscount(discountValue).calculateDiscount(basePrice, productAmount);
        }
    }

    private BigDecimal calculateDiscountValue(int productAmount) {
        int discountSteps = productAmount - minimalProductAmount;

        var computedDiscount = discountStep.multiply(BigDecimal.valueOf(discountSteps)).add(baseDiscount);

        if (computedDiscount.compareTo(maxDiscount) >= 0) {
            return maxDiscount;
        } else {
            return computedDiscount;
        }
    }
}
