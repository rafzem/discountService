package com.zemlar.discountService.service.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(UUID uuid, String name, BigDecimal basePrice) {
}
