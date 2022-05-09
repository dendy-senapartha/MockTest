package org.mockExercise7;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Project: pertemuan7
 * Package: PACKAGE_NAME
 * <p>
 * User: dendy
 * Date: 17/03/2021
 * Time: 7:49
 * <p>
 * Description : Exception Testing example
 */
public class ExceptionTesting {

//    @Rule
//    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testExceptionAndState(){
//        List<Object> list = new ArrayList<>();
//        IndexOutOfBoundsException thrown = assertThrows(
//                IndexOutOfBoundsException.class,
//                new ThrowingRunnable() {
//                    @Override
//                    public void run() throws Throwable {
////                        list.add(1,new Object());
//                    }
//                }
//        );
//        //assertion
//        assertEquals("Index: 1, Size: 0", thrown.getMessage());
//        assertTrue(list.isEmpty());
    }

    @Test
    public void testExceptionMessage(){
        List<Object> list = new ArrayList<>();
        try {
            list.get(0);
            fail("expected exception will thrown!");
        } catch (IndexOutOfBoundsException e){
            assertTrue(e == null);
        }
    }

    @Test
    public void expectedExeptionWithAnotation(){
        int divideByzero = 1/0;
    }

    @Disabled("Not Ready Yet!")
    @Test
    public void errorCollectorExample(){
//        errorCollector.addError(new Throwable("Eksepsi 1"));
//        errorCollector.addError(new Throwable("Eksepsi 2"));
//
//        try {
//            int divideByzero = 1/0;
//        } catch (ArithmeticException e){
//            errorCollector.addError(e);
//        }
//        System.out.println(errorCollector);
    }
}
