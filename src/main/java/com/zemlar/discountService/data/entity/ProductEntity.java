package com.zemlar.discountService.data.entity;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductEntity(long id, UUID uuid, String name, BigDecimal basePrice) {
}
