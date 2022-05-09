package org.mockExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: MockTest
 * Package: org.mockExample
 * <p>
 * User: dendy
 * Date: 14/04/2021
 * Time: 8:01
 * <p>
 * Description : StringCalculatorTest
 */
public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();
    //test case 1
    //inputan string kosong memberikan nilai 0
    @Test
    public void testStringUtilsTest(){
        System.out.println("result: "+ 0);
        assertEquals(0,calculator.Add(""));
    }

    //test case 2
    //menguji penambahan 1+2 = 3
    //Add(“1, 2”)
    @Test
    public void test2(){
        System.out.println("hasil : 3");
        assertEquals(3, calculator.Add("1,2"));
    }

    //exception test
    //memberikan ekspsi jika inputan ada bilangan negative
    //
    @Test
    public void testExceptionNegatif(){
        try {
            calculator.Add("-1, 2");
            fail("expected exception will thrown!");
        } catch (Exception e){
            assertTrue(e == null);
        }
    }

    @Test
    public void shouldIgnore(){
        System.out.println("Hasil: 2");
                assertEquals(2,
                        calculator.Add("1001, 2"));
    }
}
