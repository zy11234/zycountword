package com.example.springmvc.db;

import org.junit.Assert;
import org.junit.Test;

public class MyBatisSqlSessionFactoryTest {

	@Test
	public void testGetSqlSessionFactory() {
		Assert.assertNotNull(MyBatisSqlSessionFactory.getSqlSessionFactory());
	}

}
