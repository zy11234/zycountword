package com.example.springmvc.db.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Counter (a simple POJO)
 * 
 * @author bobyuan
 */
public class Counter implements Serializable {
	/** Generated serial version UID. */
	private static final long serialVersionUID = -5384594238383804609L;
	
	private Long counterId;
	private String counterName;
	private Long counterValue;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	// ---- Getter and Setter ----

	public Long getCounterId() {
		return counterId;
	}

	public void setCounterId(Long counterId) {
		this.counterId = counterId;
	}

	public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	public Long getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(Long counterValue) {
		this.counterValue = counterValue;
	}
}
