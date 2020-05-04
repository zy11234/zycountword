package com.example.springmvc.core;

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
     * @param counterValue The value of the counter.
     */
    void setValue(String counterName, long counterValue);

    /**
     * Increase the counter value by 1.
     * Note: It will create the counter if it does not exist.
     *
     * @param counterName The name of the counter.
     */
    void increase(String counterName);

    /**
     * Get value of the counter.
     * Note: It will create the counter if it does not exist.
     *
     * @param counterName The name of the counter.
     * @return The value of the counter.
     */
    long getValue(String counterName);
}
