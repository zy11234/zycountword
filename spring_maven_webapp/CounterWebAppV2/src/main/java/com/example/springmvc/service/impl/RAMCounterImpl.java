package com.example.springmvc.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.springmvc.service.INamedCounter;

/**
 * RAM based counter implementation.
 *
 * @author bobyuan
 */
public class RAMCounterImpl implements INamedCounter {
    /**
     * Use ConcurrentHashMap to hold the counters.
     */
    private final Map<String, Long> counterMap = new ConcurrentHashMap<>();

    @Override
    public void reset(String counterName) {
        Long val = 0L; // start from 0.
        counterMap.put(counterName, val);
    }

    @Override
    public void setValue(String counterName, long counterValue) {
        if (counterValue < 0) {
            throw new IllegalArgumentException("counterValue must >= 0");
        } else {
            Long val = counterValue;
            counterMap.put(counterName, val);
        }
    }

    @Override
    public long increase(String counterName) {
        Long valNew;
        Long val = counterMap.get(counterName);
        if (val != null) {
            if (val >= Long.MAX_VALUE) {
                valNew = 0L; // loop back and restart from 0.
            } else {
                valNew = val + 1; // increased by 1.
            }
        } else {
            valNew = 1L; // new counter start from 0, increased to 1.
        }

        counterMap.put(counterName, valNew);
        return valNew;
    }

    @Override
    public long getValue(String counterName) {
        Long valResult;
        Long val = counterMap.get(counterName);
        if (val != null) {
            valResult = val;
        } else {
            valResult = 0L;  // start from 0.
            counterMap.put(counterName, valResult);
        }
        return valResult;
    }
}
