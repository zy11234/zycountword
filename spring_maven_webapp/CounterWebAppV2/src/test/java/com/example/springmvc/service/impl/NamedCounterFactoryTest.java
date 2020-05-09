package com.example.springmvc.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.springmvc.service.INamedCounter;

@Tag("junit5")
public class NamedCounterFactoryTest {

    @Test
    public void test_getCounterImpl_MemoryCounter() {
        INamedCounter nc1 = NamedCounterFactory.getCounterImpl("MemoryCounter");
        Assertions.assertTrue(nc1 instanceof MemoryCounterImpl);
        INamedCounter nc2 = NamedCounterFactory.getCounterImpl("memoryCounter"); // case insensitive.
        Assertions.assertTrue(nc2 instanceof MemoryCounterImpl);
    }

    @Test
    public void test_getCounterImpl_DatabaseCounter() {
        INamedCounter nc3 = NamedCounterFactory.getCounterImpl("DatabaseCounter");
        Assertions.assertTrue(nc3 instanceof DatabaseCounterImpl);
        INamedCounter nc4 = NamedCounterFactory.getCounterImpl("databaseCounter"); // case insensitive.
        Assertions.assertTrue(nc4 instanceof DatabaseCounterImpl);
    }

    @Test
    public void test_getCounterImpl_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NamedCounterFactory.getCounterImpl(null);
        });
    }

    @Test
    public void test_getCounterImpl_Empty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NamedCounterFactory.getCounterImpl("");
        });
    }

    @Test
    public void test_getCounterImpl_NoSuchCounter() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NamedCounterFactory.getCounterImpl("NoSuchCounter");
        });
    }

}
