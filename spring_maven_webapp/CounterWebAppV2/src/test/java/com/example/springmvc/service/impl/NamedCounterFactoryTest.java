package com.example.springmvc.service.impl;

import org.junit.Assert;
import org.junit.Test;

import com.example.springmvc.service.INamedCounter;

public class NamedCounterFactoryTest {

    @Test
    public void test_getCounterImpl_MemoryCounter() {
        INamedCounter nc1 = NamedCounterFactory.getCounterImpl("MemoryCounter");
        Assert.assertTrue(nc1 instanceof MemoryCounterImpl);
        INamedCounter nc2 = NamedCounterFactory.getCounterImpl("memoryCounter"); // case insensitive.
        Assert.assertTrue(nc2 instanceof MemoryCounterImpl);
    }

    @Test
    public void test_getCounterImpl_DatabaseCounter() {
        INamedCounter nc3 = NamedCounterFactory.getCounterImpl("DatabaseCounter");
        Assert.assertTrue(nc3 instanceof DatabaseCounterImpl);
        INamedCounter nc4 = NamedCounterFactory.getCounterImpl("databaseCounter"); // case insensitive.
        Assert.assertTrue(nc4 instanceof DatabaseCounterImpl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getCounterImpl_Null() {
        NamedCounterFactory.getCounterImpl(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getCounterImpl_Empty() {
        NamedCounterFactory.getCounterImpl("");
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_getCounterImpl_NoSuchCounter() {
        NamedCounterFactory.getCounterImpl("NoSuchCounter");
    }

}
