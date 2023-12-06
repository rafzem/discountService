package com.zemlar.discountService.service.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class PercentageDiscountTest {

    @Test
    void shouldThrowExceptionOnNullPrice() {
        //given
        BigDecimal discountValue = BigDecimal.valueOf(5);
        //when then
        assertThatIllegalArgumentException().isThrownBy(() -> new PercentageDiscount(discountValue).calculateDiscount(null));

    }

    @Test
    void shouldThrowExceptionOnNullDiscountValue() {
        assertThatIllegalStateException().isThrownBy(() -> new PercentageDiscount(null));
    }

    @Test
    void shouldCalculateDiscount() {
        //given
        BigDecimal discountValue = BigDecimal.valueOf(5);
        //when
        BigDecimal discountedPrice = new PercentageDiscount(discountValue).calculateDiscount(BigDecimal.valueOf(100));
        //then
        assertThat(discountedPrice).isEqualTo(BigDecimal.valueOf(9500, 2));
    }
}