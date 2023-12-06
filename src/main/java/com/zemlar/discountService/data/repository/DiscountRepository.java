package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.service.domain.Discount;

import java.util.List;

public interface DiscountRepository {

    List<Discount> getDiscountsForProduct(Long productId);
}
