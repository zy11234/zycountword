package com.example.springmvc.db.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("junit5")
public class CounterTest {

    @Test
    public void testCounterPOJO() {
        Counter obj = new Counter();

        // initial state.
        Assertions.assertNull(obj.getCounterId());
        Assertions.assertNull(obj.getCounterName());
        Assertions.assertNull(obj.getCounterValue());

        // test getter and setter.
        obj.setCounterId(1L);
        Assertions.assertEquals(1L, obj.getCounterId().longValue());
        obj.setCounterName("counter1");
        Assertions.assertEquals("counter1", obj.getCounterName());
        obj.setCounterValue(321L);
        Assertions.assertEquals(321L, obj.getCounterValue().longValue());

        // test toString.
        //System.out.println(obj);
        Assertions.assertEquals("Counter[counterId=1,counterName=counter1,counterValue=321]", obj.toString());
    }

}
