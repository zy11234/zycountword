package com.example.springmvc.service;

/**
 * Named counter interface. 
 * 
 * @author bobyuan
 */
public interface INamedCounter {
    /**
     * Reset value of the counter to 0.
     * Note: It will create the counter if it does not exist.
     *
     * @param counterName The name of the counter.
     */
    void reset(String counterName);

    /**
     * Set value of the counter.
     * Note: It will create the counter if it does not exist.
     *
     * @param counterName The name of the counter.
     * @param counterValue The value of the counter, it must be greater or equal to 0.
     */
    void setValue(String counterName, long counterValue);

    /**
     * Increase the counter value by 1.
     * Note: 
     *  - It will create the counter if it does not exist.
     *  - It will loop back to 0 if exceeded the maximum value (2^64-1).
     *  
     * @param counterName The name of the counter.
     * @return The counter value after increase.
     */
    long increase(String counterName);

    /**
     * Get value of the counter.
     * Note: It will create the counter if it does not yet exist.
     *
     * @param counterName The name of the counter.
     * @return The value of the counter.
     */
    long getValue(String counterName);
}
