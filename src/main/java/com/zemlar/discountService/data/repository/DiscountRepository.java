package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.service.domain.Discount;

import java.util.List;
import java.util.UUID;

public interface DiscountRepository {

    List<Discount> getDiscountsForProduct(UUID productUUID);
}
