package com.example.springmvc.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.springmvc.service.INamedCounter;

@Tag("junit5")
public class RAMCounterImplTest {

    @Test
    public void test_reset_setValue() {
        final String COUNTER_NAME_1 = "counter1";
        INamedCounter nc = new RAMCounterImpl();

        //test reset().
        nc.reset(COUNTER_NAME_1);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        //test setValue().
        nc.setValue(COUNTER_NAME_1, 2);
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, 500);
        Assertions.assertEquals(500, nc.getValue(COUNTER_NAME_1));

        //test reset().
        nc.reset(COUNTER_NAME_1);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));
    }

    @Test
    public void test_setValue_invalid() {
        final String COUNTER_NAME_1 = "counter1";
        INamedCounter nc = new RAMCounterImpl();

        // if counter is not initialized, it will also start from 0.
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        // valid cases.
        nc.setValue(COUNTER_NAME_1, 0);
        nc.setValue(COUNTER_NAME_1, Long.MAX_VALUE);

        // invalid case, will throw out IllegalArgumentException.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            nc.setValue(COUNTER_NAME_1, -1);
        });
    }

    @Test
    public void test_increase() {
        final String COUNTER_NAME_2 = "counter2";
        final String COUNTER_NAME_X = "counterX";
        INamedCounter nc = new RAMCounterImpl();

        nc.reset(COUNTER_NAME_2);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // normal cases.
        Assertions.assertEquals(1, nc.increase(COUNTER_NAME_2));
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME_2));

        Assertions.assertEquals(2, nc.increase(COUNTER_NAME_2));
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME_2));

        Assertions.assertEquals(3, nc.increase(COUNTER_NAME_2));
        Assertions.assertEquals(3, nc.getValue(COUNTER_NAME_2));

        // exceptional cases #1.
        // note here COUNTER_NAME_X does not exist yet.
        Assertions.assertEquals(1, nc.increase(COUNTER_NAME_X)); //start from 0.
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME_X));

        // exceptional cases #2.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assertions.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));

        Assertions.assertEquals(0, nc.increase(COUNTER_NAME_2)); //restart from 0 to avoid overflow.
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_2));
    }

    @Test
    public void test_getValue() {
        final String COUNTER_NAME_1 = "counter1";
        final String COUNTER_NAME_Y = "counterY";
        INamedCounter nc = new RAMCounterImpl();

        //normal cases.
        nc.reset(COUNTER_NAME_1);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        nc.setValue(COUNTER_NAME_1, Long.MAX_VALUE);
        Assertions.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_1));

        //exceptional cases.
        // note here COUNTER_NAME_Y does not exist yet.
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_Y));  //start from 0.
    }


    @Test
    public void test_basic_usage() {
        final String COUNTER_NAME = "counter1";
        INamedCounter nc = new RAMCounterImpl();

        nc.reset(COUNTER_NAME);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME));

        Assertions.assertEquals(1, nc.increase(COUNTER_NAME));
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME));
        Assertions.assertEquals(2, nc.increase(COUNTER_NAME));
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME));

        nc.reset(COUNTER_NAME);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME));

        nc.increase(COUNTER_NAME);
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME));
        nc.increase(COUNTER_NAME);
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME));
    }

    @Test
    public void test_extended_usage() {
        final String COUNTER_NAME_1 = "counter1";
        final String COUNTER_NAME_2 = "counter2";
        INamedCounter nc = new RAMCounterImpl();

        nc.reset(COUNTER_NAME_1);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));
        nc.reset(COUNTER_NAME_2);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // counter1
        nc.increase(COUNTER_NAME_1);
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME_1));
        nc.increase(COUNTER_NAME_1);
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME_1));

        // counter2
        nc.increase(COUNTER_NAME_2);
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME_2));
        nc.increase(COUNTER_NAME_2);
        Assertions.assertEquals(2, nc.getValue(COUNTER_NAME_2));

        // counter2 set value.
        nc.setValue(COUNTER_NAME_2, 5000);
        Assertions.assertEquals(5000, nc.getValue(COUNTER_NAME_2));
        Assertions.assertEquals(5001, nc.increase(COUNTER_NAME_2));
        Assertions.assertEquals(5001, nc.getValue(COUNTER_NAME_2));

        // restart from 0 to avoid overflow.
        nc.setValue(COUNTER_NAME_2, Long.MAX_VALUE);
        Assertions.assertEquals(Long.MAX_VALUE, nc.getValue(COUNTER_NAME_2));
        Assertions.assertEquals(0, nc.increase(COUNTER_NAME_2));
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_2));

        // counter1 reset.
        Assertions.assertEquals(3, nc.increase(COUNTER_NAME_1));
        Assertions.assertEquals(3, nc.getValue(COUNTER_NAME_1));
        nc.reset(COUNTER_NAME_1);
        Assertions.assertEquals(0, nc.getValue(COUNTER_NAME_1));

        // counter2 continue.
        nc.increase(COUNTER_NAME_2);
        Assertions.assertEquals(1, nc.getValue(COUNTER_NAME_2));
    }
}
