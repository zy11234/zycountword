package com.example.springmvc.db.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.springmvc.db.MyBatisTransactionTemplate;
import com.example.springmvc.db.entity.Counter;
import com.example.springmvc.db.mapper.CounterMapper;

/**
 * Data Access Object for Counter entity.
 * 
 * @author bobyuan
 */
public class CounterDAO {
	public void insert(Counter counter) {
		MyBatisTransactionTemplate template = new MyBatisTransactionTemplate() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.insertCounter(counter);
				return null; // nothing to return.
			}
		};

		template.execute();
	}

	public void update(Counter counter) {
		MyBatisTransactionTemplate template = new MyBatisTransactionTemplate() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.updateCounter(counter);
				return null; // nothing to return.
			}
		};

		template.execute();
	}

	public void delete(String counterName) {
		MyBatisTransactionTemplate template = new MyBatisTransactionTemplate() {
			@Override
			public Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				mapper.deleteCounter(counterName);
				return null; // nothing to return.
			}
		};

		template.execute();
	}

	public Counter getByName(String counterName) {
		MyBatisTransactionTemplate template = new MyBatisTransactionTemplate() {
			@Override
			protected Object performInSession(SqlSession session) {
				CounterMapper mapper = session.getMapper(CounterMapper.class);
				return mapper.getCounterByName(counterName);
			}
		};

		return (Counter) template.execute();
	}
}
