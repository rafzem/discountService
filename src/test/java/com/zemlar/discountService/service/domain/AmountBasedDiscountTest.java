package com.zemlar.discountService.service.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class AmountBasedDiscountTest {


    @Test
    void shouldThrowExceptionWhenNoBaseDiscountIsSet() {
        assertThatIllegalStateException().isThrownBy(() -> new AmountBasedDiscount(1, null,
                BigDecimal.ONE, BigDecimal.ONE));
    }

    @Test
    void shouldThrowExceptionWhenNoDiscountStepIsSet() {
        assertThatIllegalStateException().isThrownBy(() -> new AmountBasedDiscount(1, BigDecimal.ONE,
                BigDecimal.ONE, null));
    }

    @Test
    void shouldThrowExceptionWhenNoMaxDiscountIsSet() {
        assertThatIllegalStateException().isThrownBy(() -> new AmountBasedDiscount(1, BigDecimal.ONE,
                null, BigDecimal.ONE));
    }

    @Test
    void shouldThrowExceptionWhenNegativeProductAmountIsSet() {
        assertThatIllegalStateException().isThrownBy(() -> new AmountBasedDiscount(-1, BigDecimal.ONE,
                BigDecimal.ONE, BigDecimal.ONE));
    }

    @Test
    void shouldThrowExceptionOnZeroAmount() {
        assertThatIllegalArgumentException().isThrownBy(() -> new AmountBasedDiscount(2, BigDecimal.ONE,
                BigDecimal.ONE, BigDecimal.ONE).calculateDiscount(BigDecimal.TEN, 0));
    }


    @Test
    void shouldNotCalculateDiscountWhenMinimalAmountIsNotReached() {

        //given
        int minimalOrderedProduct = 3;


        //when
        BigDecimal productPrice = new AmountBasedDiscount(minimalOrderedProduct, BigDecimal.valueOf(5),
                BigDecimal.valueOf(50), BigDecimal.valueOf(2))
                .calculateDiscount(BigDecimal.TEN, 2);

        //then
        assertThat(productPrice).isEqualTo(BigDecimal.TEN);

    }

    @Test
    void shouldCalculateDiscountWhenMinimalAmountIsReached() {

        //given
        int minimalOrderedProduct = 2;
        int basePrice = 100;


        //when
        BigDecimal productPrice = new AmountBasedDiscount(minimalOrderedProduct, BigDecimal.valueOf(5),
                BigDecimal.valueOf(50), BigDecimal.valueOf(2))
                .calculateDiscount(BigDecimal.valueOf(basePrice), 4);

        //then
        assertThat(productPrice).isEqualTo(BigDecimal.valueOf(36400, 2));  //5% + 2*2% = 9%

    }

    @Test
    void shouldNotCountBiggerDiscountThanMax() {

        //given
        int minimalOrderedProduct = 2;
        int basePrice = 100;


        //when
        BigDecimal productPrice = new AmountBasedDiscount(minimalOrderedProduct, BigDecimal.valueOf(5),
                BigDecimal.valueOf(50), BigDecimal.valueOf(5))
                .calculateDiscount(BigDecimal.valueOf(basePrice), 20);

        //then
        assertThat(productPrice).isEqualTo(BigDecimal.valueOf(100000, 2));  //5% + 18*5% > 50% -> Max discount set

    }

}