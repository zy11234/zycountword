package com.example.springmvc.db;

import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("junit5")
public class MyBatisSqlSessionWrapperTest {

    @Test
    public void testPerformInSessionReturns() {
        // returns null.
        MyBatisSqlSessionWrapper wrapper1 = new MyBatisSqlSessionWrapper() {
            @Override
            protected Object performInSession(SqlSession session) {
                return null;
            }
        };

        Object ret1 = wrapper1.execute();
        Assertions.assertNull(ret1);

        // returns an object.
        MyBatisSqlSessionWrapper wrapper2 = new MyBatisSqlSessionWrapper() {
            @Override
            protected Object performInSession(SqlSession session) {
                return new Date();
            }
        };

        Object ret2 = wrapper2.execute();
        Assertions.assertTrue(ret2 instanceof Date);
    }

    @Test
    public void testPerformInSessionExceptions() {
        MyBatisSqlSessionWrapper wrapper = new MyBatisSqlSessionWrapper() {
            @Override
            protected Object performInSession(SqlSession session) {
                throw new RuntimeException("This is a test exception from unit test");
            }
        };

        Assertions.assertThrows(RuntimeException.class, () -> {
            wrapper.execute();
        });
    }

}
