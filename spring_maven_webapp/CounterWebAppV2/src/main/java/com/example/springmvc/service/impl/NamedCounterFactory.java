package com.example.springmvc.service.impl;

import com.example.springmvc.service.INamedCounter;

/**
 * Factory to get counter implementations.
 *
 * @author bobyuan
 */
public class NamedCounterFactory {

    /** Enumerate of the available counter implementation types. */
    public enum CounterType {
        RAM_COUNTER, DB_COUNTER;
    }

    /**
     * Get a counter implementation by type, default is RAMCounterImpl.
     *
     * @param counterType The given counter type.
     * @return A INamedCounter implementation.
     */
    public static INamedCounter getCounterImpl(CounterType counterType) {
        INamedCounter impl = null;
        if (counterType == CounterType.RAM_COUNTER) {
            impl = new RAMCounterImpl();
        } else if (counterType == CounterType.DB_COUNTER) {
            impl = new DBCounterImpl();
        } else {
            // default.
            impl = new RAMCounterImpl();
        }

        return impl;
    }
}
