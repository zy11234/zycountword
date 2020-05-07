package com.example.springmvc.service.impl;

import org.junit.Assert;
import org.junit.Test;

import com.example.springmvc.service.INamedCounter;
import com.example.springmvc.service.impl.MemoryCounterImpl;

public class MemoryCounterImplTest {

    @Test
    public void test_reset_setValue() {
        final String COUNTER_NAME_1 = "counter1";
        INamedCounter nc = new MemoryCounterImpl();

        //test reset().
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        //test setValue().
        nc.setValue(COUNTER_NAME_1, 2);
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, 500);
        Assert.assertEquals(500, nc.getValue(COUNTER_NAME_1));
        
        //test reset().
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setValue_invalid() {
        final String COUNTER_NAME_1 = "counter1";
        INamedCounter nc = new MemoryCounterImpl();
        
        // if counter is not initialized, it will also start from 0.
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        // valid cases.
        nc.setValue(COUNTER_NAME_1, 0);
        nc.setValue(COUNTER_NAME_1, Long.MAX_VALUE);
        
        // invalid case, will throw out IllegalArgumentException.
        nc.setValue(COUNTER_NAME_1, -1);
    }
    
    @Test
    public void test_increase() {
        final String COUNTER_NAME_2 = "counter2";
        final String COUNTER_NAME_X = "counterX";
        INamedCounter nc = new MemoryCounterImpl();

        nc.reset(COUNTER_NAME_2);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // normal cases.
        Assert.assertEquals(1, nc.increase(COUNTER_NAME_2));
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_2));

        Assert.assertEquals(2, nc.increase(COUNTER_NAME_2));
        Assert.assertEquals(2, nc.getValue(COUNTER_NAME_2));

        Assert.assertEquals(3, nc.increase(COUNTER_NAME_2));
        Assert.assertEquals(3, nc.getValue(COUNTER_NAME_2));

        // exceptional cases #1.
        // note here COUNTER_NAME_X does not exist yet.
        Assert.assertEquals(1, nc.increase(COUNTER_NAME_X)); //start from 0.
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_X));  

        // exceptional cases #2.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));

        Assert.assertEquals(0, nc.increase(COUNTER_NAME_2)); //restart from 0 to avoid overflow.
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));  
    }

    @Test
    public void test_getValue() {
        final String COUNTER_NAME_1 = "counter1";
        final String COUNTER_NAME_Y = "counterY";
        INamedCounter nc = new MemoryCounterImpl();

        //normal cases.
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_1));

        //exceptional cases.
        // note here COUNTER_NAME_Y does not exist yet.
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_Y));  //start from 0.
    }


    @Test
    public void test_basic_usage() {
        final String COUNTER_NAME = "counter1";
        INamedCounter nc = new MemoryCounterImpl();
        
        nc.reset(COUNTER_NAME);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME));

        Assert.assertEquals(1, nc.increase(COUNTER_NAME));
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME));
        Assert.assertEquals(2, nc.increase(COUNTER_NAME));
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
        INamedCounter nc = new MemoryCounterImpl();
        
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
        Assert.assertEquals(5001, nc.increase(COUNTER_NAME_2));
        Assert.assertEquals(5001, nc.getValue(COUNTER_NAME_2));

        // restart from 0 to avoid overflow.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assert.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));
        Assert.assertEquals(0, nc.increase(COUNTER_NAME_2));
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // counter1 reset.
        Assert.assertEquals(3, nc.increase(COUNTER_NAME_1));
        Assert.assertEquals(3, nc.getValue(COUNTER_NAME_1));
        nc.reset(COUNTER_NAME_1);
        Assert.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        // counter2 continue.
        nc.increase(COUNTER_NAME_2);
        Assert.assertEquals(1, nc.getValue(COUNTER_NAME_2));
    }
}
