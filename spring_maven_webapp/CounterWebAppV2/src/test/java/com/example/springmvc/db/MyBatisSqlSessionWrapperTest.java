package com.example.springmvc.db;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertNull(ret1);

        // returns an object.
        MyBatisSqlSessionWrapper wrapper2 = new MyBatisSqlSessionWrapper() {
            @Override
            protected Object performInSession(SqlSession session) {
                return new Date();
            }
        };

        Object ret2 = wrapper2.execute();
        Assert.assertTrue(ret2 instanceof Date);
    }

    @Test(expected = RuntimeException.class)
    public void testPerformInSessionExceptions() {
        MyBatisSqlSessionWrapper wrapper = new MyBatisSqlSessionWrapper() {
            @Override
            protected Object performInSession(SqlSession session) {
                throw new RuntimeException("This is a test exception from unit test");
            }
        };

        wrapper.execute();
    }

}
