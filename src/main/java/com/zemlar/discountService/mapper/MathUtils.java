package com.zemlar.discountService.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {
    private final static BigDecimal divider = BigDecimal.valueOf(100);
    private final static int scale = 2;

    public static BigDecimal calculateDiscountFactor(BigDecimal value) {
        return divider.subtract(value).divide(divider, scale, RoundingMode.FLOOR);
    }
}
