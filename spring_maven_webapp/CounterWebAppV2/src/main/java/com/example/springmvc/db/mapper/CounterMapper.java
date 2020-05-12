package com.example.springmvc.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.springmvc.db.entity.Counter;

public interface CounterMapper {
	String SELECT_COUNTER = "SELECT CounterId, CounterName, CounterValue FROM TabCounter WHERE CounterName = #{counterName}";
	String INSERT_COUNTER = "INSERT INTO TabCounter(CounterName, CounterValue) VALUES (#{counterName}, #{counterValue})";
	String UPDATE_COUNTER = "UPDATE TabCounter SET CounterValue = #{counterValue} WHERE CounterName = #{counterName}";
	String DELETE_COUNTER = "DELETE FROM TabCounter WHERE CounterName = #{counterName}";

	@Results({
		@Result(property = "counterId", column = "CounterId"),
        @Result(property = "counterName", column = "CounterName"),
        @Result(property = "counterValue", column = "CounterValue")
    })
	@Select(SELECT_COUNTER)
	Counter getCounterByName(String counterName);

	@Insert(INSERT_COUNTER)
	void insertCounter(Counter counter);

	@Update(UPDATE_COUNTER)
	void updateCounter(Counter counter);
	
	@Update(DELETE_COUNTER)
	void deleteCounter(String counterName);
}
