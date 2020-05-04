package com.example.springmvc.core;

import org.junit.Assert;
import org.junit.Test;

import com.example.springmvc.core.INamedCounter;
import com.example.springmvc.core.MemoryCounterImpl;

public class MemoryCounterImplTest {

    private INamedCounter getCounterImpl() {
        return new MemoryCounterImpl();
    }

    @Test
    public void test_reset_setValue() {
        final String COUNTER_NAME_1 = "counter1";
        INamedCounter nc = getCounterImpl();

        //test reset().
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        //test setValue().
        nc.setValue(COUNTER_NAME_1, 2);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, 500);
        Assert.assertEquals(500, nc.getValue(COUNTER_NAME_1));
    }

    @Test
    public void test_increase() {
        final String COUNTER_NAME_2 = "counter2";
        final String COUNTER_NAME_X = "counterX";
        INamedCounter nc = getCounterImpl();

        nc.reset(COUNTER_NAME_2);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // normal cases.
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_2));

        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_2));

        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(3, nc.getValue(COUNTER_NAME_2));

        // exceptional cases #1.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));

        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));  //restart from 0 to avoid overflow.

        // exceptional cases #2.
        nc.increase(COUNTER_NAME_X);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_X));  //start from 0.
    }

    @Test
    public void test_getValue() {
        final String COUNTER_NAME_1 = "counter1";
        final String COUNTER_NAME_Y = "counterY";
        INamedCounter nc = getCounterImpl();

        //normal cases.
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_1));

        //exceptional cases.
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_Y));  //start from 0.
    }


    @Test
    public void test_basic_usage() {
        final String COUNTER_NAME = "counter1";

        INamedCounter nc = getCounterImpl();
        nc.reset(COUNTER_NAME);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME));

        nc.increase(COUNTER_NAME);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME));
        nc.increase(COUNTER_NAME);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME));

        nc.reset(COUNTER_NAME);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME));

        nc.increase(COUNTER_NAME);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME));
        nc.increase(COUNTER_NAME);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME));
    }

    @Test
    public void test_extended_usage() {
        final String COUNTER_NAME_1 = "counter1";
        final String COUNTER_NAME_2 = "counter2";

        INamedCounter nc = getCounterImpl();
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));
        nc.reset(COUNTER_NAME_2);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // counter1
        nc.increase(COUNTER_NAME_1);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_1));
        nc.increase(COUNTER_NAME_1);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_1));

        // counter2
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_2));
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_2));

        // counter2 set value.
        nc.setValue(COUNTER_NAME_2, 5000);
        Assert.assertEquals(5000, nc.getValue(COUNTER_NAME_2));
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(5001, nc.getValue(COUNTER_NAME_2));

        // restart from 0 to avoid overflow.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // counter1 reset.
        nc.increase(COUNTER_NAME_1);
        Assert.assertEquals(3, nc.getValue(COUNTER_NAME_1));
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        // counter2 continue.
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_2));
    }
}
