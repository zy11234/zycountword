package com.example.springmvc.db.model;

import org.junit.Assert;

import org.junit.Test;

public class CounterTest {

    @Test
    public void testCounterPOJO() {
        Counter obj = new Counter();

        // initial state.
        Assert.assertNull(obj.getCounterId());
        Assert.assertNull(obj.getCounterName());
        Assert.assertNull(obj.getCounterValue());

        // test getter and setter.
        obj.setCounterId(1L);
        Assert.assertEquals(1L, obj.getCounterId().longValue());
        obj.setCounterName("counter1");
        Assert.assertEquals("counter1", obj.getCounterName());
        obj.setCounterValue(321L);
        Assert.assertEquals(321L, obj.getCounterValue().longValue());

        // test toString.
        //System.out.println(obj);
        Assert.assertEquals("Counter[counterId=1,counterName=counter1,counterValue=321]", obj.toString());
    }

}
