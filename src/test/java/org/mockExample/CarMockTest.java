package org.mockExample;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Project: MockTest
 * Package: org.mockExample
 * <p>
 * User: dendy
 * Date: 07/04/2021
 * Time: 8:06
 * <p>
 * Description : class to test car mock object
 */
public class CarMockTest {
    //create mock object of car
    private Object myCar = mock(Object.class);

    @Test
    public void testIfMyCarIsCar(){
        assertTrue(myCar instanceof Car);
    }
}
