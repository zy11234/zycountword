package com.example.springmvc.service.impl;

import com.example.springmvc.db.dao.CounterDAO;
import com.example.springmvc.db.entity.Counter;
import com.example.springmvc.service.INamedCounter;

/**
 * DB based counter implementation.
 *
 * @author bobyuan
 */
public class DatabaseCounterImpl implements INamedCounter {
    private final CounterDAO dao = new CounterDAO();

    @Override
    public void reset(String counterName) {
        long counterValue = 0; // start from 0.
        Counter counterInDb = dao.getByName(counterName);
        if (counterInDb != null) {
            // update into database.
            counterInDb.setCounterValue(counterValue);
            dao.update(counterInDb);
        } else {
            // insert into database.
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setCounterValue(counterValue);
            dao.insert(counter);
        }
    }

    @Override
    public void setValue(String counterName, long counterValue) {
    	if (counterValue < 0) {
    		throw new IllegalArgumentException("counterValue must >= 0");
    	} else {
	        Counter counterInDb = dao.getByName(counterName);
	        if (counterInDb != null) {
	            // update into database.
	            counterInDb.setCounterValue(counterValue);
	            dao.update(counterInDb);
	        } else {
	            // insert into database.
	            Counter counter = new Counter();
	            counter.setCounterName(counterName);
	            counter.setCounterValue(counterValue);
	            dao.insert(counter);
	        }
    	}
    }

    @Override
    public long increase(String counterName) {
    	Long valNew;
    	Counter counterInDb = dao.getByName(counterName);
        if (counterInDb != null) {
        	Long val = counterInDb.getCounterValue();
        	if (val >= Long.MAX_VALUE) {
                valNew = 0L; // loop back and restart from 0.
            } else {
                valNew = val + 1; // increased by 1.
            }
        	
        	// update into database.
            counterInDb.setCounterValue(valNew);
            dao.update(counterInDb);
        } else {
        	valNew = 1L; // new counter start from 0, increased to 1.

            // insert into database.
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setCounterValue(valNew);
            dao.insert(counter);
        }
        
        return valNew;
    }

    @Override
    public long getValue(String counterName) {
    	Long val;
        Counter counterInDb = dao.getByName(counterName);
        if (counterInDb != null) {
        	val = counterInDb.getCounterValue();
        } else {
        	val = 0L; // start from 0.

            // insert into database.
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setCounterValue(val);
            dao.insert(counter);
        }
        
        return val;
    }
}
