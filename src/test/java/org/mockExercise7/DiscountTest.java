package org.mockExercise7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author dendy
 * @Date 25/04/2022
 * @Time 13.33
 * Description : test To test Discount
 */
public class DiscountTest {
    private Discount discount;

    @BeforeEach
    private void beforEach() {
        discount = new Discount();
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(0, 14500),
                Arguments.of(5, 16500),
                Arguments.of(7, 24750),
                Arguments.of(8.5f, 26000),
                Arguments.of(-1, -4000),
                Arguments.of(-1, 1000001)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testDiscount(float expected, float price) {
        assertNotNull(discount);
        assertEquals(expected, discount.getDiscountPercentage(price));
    }

    private static Stream<Arguments> BVA1Parameters() {
        return Stream.of(
                Arguments.of(true, 24999),
                Arguments.of(false, 25000),
                Arguments.of(false, 25001)
        );
    }

    @ParameterizedTest
    @MethodSource("BVA1Parameters")
    public void testBVA1Discount(boolean expected, float price) {
        assertNotNull(discount);
        assertEquals(expected, discount.getDiscountPercentage(price) == 7);
    }
}
