package com.example.springmvc.service.impl;

import com.example.springmvc.service.INamedCounter;
import com.example.springmvc.service.impl.MemoryCounterImpl;
import com.example.springmvc.service.impl.DatabaseCounterImpl;

/**
 * Factory to get counter implementation (MemoryCounter / DatabaseCounter).
 *
 * @author bobyuan
 *
 */
public class NamedCounterFactory {

    public static INamedCounter getCounterImpl(String counterType) {
        INamedCounter namedCounter = null;
        if ("MemoryCounter".equalsIgnoreCase(counterType)) {
            namedCounter = new MemoryCounterImpl();
        } else if ("DatabaseCounter".equalsIgnoreCase(counterType)) {
            namedCounter = new DatabaseCounterImpl();
        }

        if (namedCounter != null) {
            return namedCounter;
        } else {
            // throw exception if goes here.
            throw new IllegalArgumentException("Invalid counterType: " + counterType);
        }
    }
}
