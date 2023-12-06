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
        assertThatIllegalArgumentException().isThrownBy(() -> new PercentageDiscount(discountValue)
                .calculateDiscount(null, 1));

    }

    @Test
    void shouldThrowExceptionOnNullDiscountValue() {
        assertThatIllegalStateException().isThrownBy(() -> new PercentageDiscount(null));
    }

    @Test
    void shouldThrowExceptionOnZeroAmount() {
        //given
        BigDecimal discountValue = BigDecimal.valueOf(5);
        //when then
        assertThatIllegalArgumentException().isThrownBy(() -> new PercentageDiscount(discountValue)
                .calculateDiscount(BigDecimal.TEN, 0));
    }

    @Test
    void shouldCalculateDiscountForOneProduct() {
        //given
        BigDecimal discountValue = BigDecimal.valueOf(5);
        //when
        BigDecimal discountedPrice = new PercentageDiscount(discountValue).calculateDiscount(BigDecimal.valueOf(100), 1);
        //then
        assertThat(discountedPrice).isEqualTo(BigDecimal.valueOf(9500, 2));
    }
    @Test
    void shouldCalculateDiscountForTwoProducts() {
        //given
        BigDecimal discountValue = BigDecimal.valueOf(5);
        //when
        BigDecimal discountedPrice = new PercentageDiscount(discountValue).calculateDiscount(BigDecimal.valueOf(100), 2);
        //then
        assertThat(discountedPrice).isEqualTo(BigDecimal.valueOf(19000, 2));
    }
}