package com.example.springmvc.core;

import com.example.springmvc.db.dao.CounterDAO;
import com.example.springmvc.db.model.Counter;

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
    public void increase(String counterName) {
        Counter counterInDb = dao.getByName(counterName);
        if (counterInDb != null) {
            long counterValue = counterInDb.getCounterValue();
            counterInDb.setCounterValue(counterValue + 1);
            dao.update(counterInDb);
        } else {
            // start from 0.
            long counterValue = 0;

            // insert into database.
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setCounterValue(counterValue + 1);
            dao.insert(counter);
        }
    }

    @Override
    public long getValue(String counterName) {
        long counterValue;
        Counter counterInDb = dao.getByName(counterName);
        if (counterInDb != null) {
            counterValue = counterInDb.getCounterValue();
        } else {
            // start from 0.
            counterValue = 0;

            // insert into database.
            Counter counter = new Counter();
            counter.setCounterName(counterName);
            counter.setCounterValue(counterValue);
            dao.insert(counter);
        }
        return counterValue;
    }
}
