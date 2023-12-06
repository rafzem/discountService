package com.zemlar.discountService.api.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(UUID uuid, String name, BigDecimal price) {}
