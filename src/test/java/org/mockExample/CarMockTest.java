package org.mockExample;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testIfMyCarIsCar() {
        assertTrue(myCar instanceof Car);
    }

    @Test
    public void testDefaultValueOfMyCar() {
        assertFalse(myCar.needsFuel(), "my car need fuel");
        assertEquals(0.0, myCar.getEngineTemperature(), 1e-3, "my car engine temperature should be 0.0");
    }

    @Test
    public void testGiveValueOnMockObject() {
        assertFalse(myCar.needsFuel(), "my car dont need fuel!");
        when(myCar.needsFuel()).thenReturn(true);
        assertTrue(myCar.needsFuel(), "my car need fuel!");
    }

    @Test
    public void testMyCarHaveException() {
        //mengkondisikan bila method needsfuel
        // dipanggil akan memberikan eksepsi
        when(myCar.needsFuel())
                .thenThrow(new RuntimeException());
        myCar.needsFuel();
    }

    @Test
    public void verifyThatMockMethodBeingCalled() {
        myCar.driveTo("Sweet Campus UKDW");
        myCar.needsFuel();
        //method any() akan mengabaikan value
        // dari input param. hanya fokus pada
        // ada atau tidaknya input param saja
        verify(myCar).driveTo(any());
        verify(myCar).needsFuel();
    }
}
