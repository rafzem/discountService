package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;

public record Offer(Product product, BigDecimal discountPrice, int offerAmount) {
}
