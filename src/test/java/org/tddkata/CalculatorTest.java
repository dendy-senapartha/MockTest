package org.tddkata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dendy
 * @Date 17/05/2022
 * @Time 09.49
 * Description :Calculator Test. an exercise for TDD
 */
public class CalculatorTest {

    StringCalculator stringCalculator;
    @BeforeAll
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testTwoNumbers(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testThreeNumbers(){
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void testNewLine(){
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testNegativeNumver(){
        try {
            stringCalculator.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }

        try {
            stringCalculator.add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
        }
    }

    @Test
    public void testOverThousand(){
        assertEquals(2, stringCalculator.add("1000,2"));
    }

    @Test
    public void testOtherDelimiter(){
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
}
