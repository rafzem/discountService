package com.zemlar.discountService.api.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OfferDto(UUID uuid, String name, BigDecimal basePrice, BigDecimal discountPrice, int offerAmount) {
}
