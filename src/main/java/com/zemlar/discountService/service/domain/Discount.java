package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal calculateDiscount(BigDecimal basePrice);
}
