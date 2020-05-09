package com.example.springmvc.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("junit5")
public class MyBatisSqlSessionFactoryTest {

    @Test
    public void testGetSqlSessionFactory() {
        Assertions.assertNotNull(MyBatisSqlSessionFactory.getSqlSessionFactory());
    }

}
