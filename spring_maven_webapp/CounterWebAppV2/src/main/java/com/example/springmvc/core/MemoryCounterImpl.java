package com.example.springmvc.core;

import java.util.HashMap;
import java.util.Map;

/**
 * RAM based counter implementation.
 *
 * @author bobyuan
 */
public class MemoryCounterImpl implements INamedCounter {
    private final Map<String, Long> counterMap = new HashMap<String, Long>();

    @Override
    public void reset(String counterName) {
        Long val = 0L; // start from 0.
        counterMap.put(counterName, val);
    }

    @Override
    public void setValue(String counterName, long counterValue) {
        Long val = counterValue;
        counterMap.put(counterName, val);
    }

    @Override
    public void increase(String counterName) {
        Long valNew;
        Long val = counterMap.get(counterName);
        if (val != null) {
            if (val >= Long.MAX_VALUE) {
                valNew = 0L; // restart from 0, to avoid overflow.
            } else {
                valNew = val + 1; // increased by 1.
            }
        } else {
            valNew = 1L; // new counter start from 0, increased to 1.
        }
        counterMap.put(counterName, valNew);
    }

    @Override
    public long getValue(String counterName) {
        Long lngResult;
        Long val = counterMap.get(counterName);
        if (val != null) {
            lngResult = val;
        } else {
            lngResult = 0L;  // start from 0.
            counterMap.put(counterName, lngResult);
        }
        return lngResult.longValue();
    }
}
