package com.zemlar.discountService.mapper;

import com.zemlar.discountService.data.entity.DiscountEntity;
import com.zemlar.discountService.service.domain.AmountBasedDiscount;
import com.zemlar.discountService.service.domain.PercentageDiscount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DiscountMapper {

    AmountBasedDiscount mapToAmountBasedDiscount(DiscountEntity discountEntity);
    PercentageDiscount mapToPercentageDiscount(DiscountEntity discountEntity);
}
