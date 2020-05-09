package com.example.springmvc.db.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.springmvc.db.entity.Counter;

@Tag("junit5")
public class CounterDAOTest {
    private static final String COUNTER_NAME_1 = "counterForUnitTesting1";

    @Test
    public void testCounter1() {
        CounterDAO dao = new CounterDAO();

        // insert
        Counter counter1 = new Counter();
        counter1.setCounterName(COUNTER_NAME_1);
        counter1.setCounterValue(123L);
        dao.insert(counter1);
        // System.out.println("counter1 saved: " + counter1);

        // select
        Counter counter1InDb = dao.getByName(COUNTER_NAME_1);
        Assertions.assertEquals(Long.valueOf(123L), counter1InDb.getCounterValue());

        // update
        counter1.setCounterValue(456L);
        dao.update(counter1);
        // System.out.println("counter1 updated: " + counter1);

        counter1InDb = dao.getByName(COUNTER_NAME_1);
        Assertions.assertEquals(Long.valueOf(456L), counter1InDb.getCounterValue());

        // update again
        counter1.setCounterValue(789L);
        dao.update(counter1);
        // System.out.println("counter1 updated again: " + counter1);

        counter1InDb = dao.getByName(COUNTER_NAME_1);
        Assertions.assertEquals(Long.valueOf(789L), counter1InDb.getCounterValue());

        // delete
        dao.delete(COUNTER_NAME_1);
        // System.out.println("counter1 deleted.");

        counter1InDb = dao.getByName(COUNTER_NAME_1);
        Assertions.assertNull(counter1InDb);
    }
}
