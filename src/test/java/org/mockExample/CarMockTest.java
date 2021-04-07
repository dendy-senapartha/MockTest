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
    private Car myCar = mock(Car.class);

    @Test
    public void testIfMyCarIsCar(){
        assertTrue(myCar instanceof Car);
    }

    @Test
    public void testDefaultValueOfMyCar(){
        assertFalse("my car need fuel", myCar.needsFuel());
        assertEquals("my car engine temperature should be 0.0",
                0.0, myCar.getEngineTemperature(), 1e-3);
    }

    @Test
    public void testGiveValueOnMockObject(){
        assertFalse("my car dont need fuel!", myCar.needsFuel());
        when(myCar.needsFuel()).thenReturn(true);
        assertTrue("my car need fuel!" , myCar.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void testMyCarHaveException(){
        //mengkondisikan bila method needsfuel
        // dipanggil akan memberikan eksepsi
        when(myCar.needsFuel())
                .thenThrow(new RuntimeException());
        myCar.needsFuel();
    }

    @Test
    public void verifyThatMockMethodBeingCalled(){
        myCar.driveTo("Sweet Campus UKDW");
        myCar.needsFuel();
        //method any() akan mengabaikan value
        // dari input param. hanya fokus pada
        // ada atau tidaknya input param saja
        verify(myCar).driveTo(any());
        verify(myCar).needsFuel();
    }
}
