package com.zemlar.discountService.data.entity;

import java.math.BigDecimal;

public record DiscountEntity(long id, long discountGroupId, DiscountType type, BigDecimal discountValue,
                             int minimalProductAmount, BigDecimal baseDiscount, BigDecimal maxDiscount,
                             BigDecimal discountStep) {

   public  enum DiscountType {
        COUNT_BASED("count"), PERCENTAGE_BASED("percentage");
        private final String type;

        DiscountType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
