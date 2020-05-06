package com.example.springmvc.db.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.springmvc.db.MyBatisSqlSessionWrapper;
import com.example.springmvc.db.entity.Counter;

/**
 * Data Access Object for Counter entity.
 * 
 * @author bobyuan
 */
public class CounterDAO {
	public void insert(Counter counter) {
		MyBatisSqlSessionWrapper sessionWrapper = new MyBatisSqlSessionWrapper() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.insertCounter(counter);
				return null; // nothing to return.
			}
		};

		sessionWrapper.execute();
	}

	public void update(Counter counter) {
		MyBatisSqlSessionWrapper sessionWrapper = new MyBatisSqlSessionWrapper() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.updateCounter(counter);
				return null; // nothing to return.
			}
		};

		sessionWrapper.execute();
	}

	public void delete(String counterName) {
		MyBatisSqlSessionWrapper sessionWrapper = new MyBatisSqlSessionWrapper() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.deleteCounter(counterName);
				return null; // nothing to return.
			}
		};

		sessionWrapper.execute();
	}

	public Counter getByName(String counterName) {
		MyBatisSqlSessionWrapper sessionWrapper = new MyBatisSqlSessionWrapper() {
			@Override
			protected Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				return mapper.getCounterByName(counterName);
			}
		};

		return (Counter) sessionWrapper.execute();
	}
}
