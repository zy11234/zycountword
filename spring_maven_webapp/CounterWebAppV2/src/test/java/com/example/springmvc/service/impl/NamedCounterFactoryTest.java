package com.example.springmvc.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.springmvc.service.INamedCounter;

@Tag("junit5")
public class NamedCounterFactoryTest {

    @Test
    public void test_getCounterImpl_RAMCounter() {
        INamedCounter nc1 = NamedCounterFactory.getCounterImpl(NamedCounterFactory.CounterType.RAM_COUNTER);
        Assertions.assertTrue(nc1 instanceof RAMCounterImpl);
    }

    @Test
    public void test_getCounterImpl_DBCounter() {
        INamedCounter nc3 = NamedCounterFactory.getCounterImpl(NamedCounterFactory.CounterType.DB_COUNTER);
        Assertions.assertTrue(nc3 instanceof DBCounterImpl);
    }

    @Test
    public void test_getCounterImpl_default() {
        INamedCounter nc1 = NamedCounterFactory.getCounterImpl(null);
        Assertions.assertTrue(nc1 instanceof RAMCounterImpl);
    }
}
