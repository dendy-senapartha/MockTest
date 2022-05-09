package org.mockExercise7;


import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: pertemuan7
 * Package: PACKAGE_NAME
 * <p>
 * User: dendy
 * Date: 17/03/2021
 * Time: 8:40
 * <p>
 * Description : paramterized test example
 */

public class ParameterTest {
    int var1;
    int var2;
    int expected;
    Arithmatics arithmatics;

    public ParameterTest(int var1, int var2, int expected) {
        this.var1 = var1;
        this.var2 = var2;
        this.expected = expected;
    }

    @BeforeEach
    public void init() {
        arithmatics = new Arithmatics();
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testParametersFromMethod(int expected,
                                         int value1,
                                         int value2) {
        Arithmatics arithmatics = new Arithmatics();
        assertEquals(expected, arithmatics.sum(value1, value2));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(2, 1, 1),
                Arguments.of(5, 3, 2),
                Arguments.of(6, 3, 3)
        );
    }
}
