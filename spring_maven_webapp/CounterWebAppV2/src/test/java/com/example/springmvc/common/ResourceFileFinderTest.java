package com.example.springmvc.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("junit5")
public class ResourceFileFinderTest {
    @Test
    public void testBasicUsage() {
        Assertions.assertEquals("logback-test.xml", ResourceFileFinder.find("logback-test.xml"));
        Assertions.assertEquals("logback-test.xml", ResourceFileFinder.find("logback-test.xml", "logback.xml"));

        Assertions.assertEquals("logback-test.xml", ResourceFileFinder.find("no-such-file.xml", "logback-test.xml"));
        Assertions.assertEquals("logback.xml", ResourceFileFinder.find("no-such-file.xml", "logback.xml"));

        Assertions.assertNull(ResourceFileFinder.find("no-such-file-1.xml"));
        Assertions.assertNull(ResourceFileFinder.find("no-such-file-1.xml", "no-such-file-2.xml"));
        Assertions.assertNull(ResourceFileFinder.find("no-such-file-1.xml", "no-such-file-2.xml", "no-such-file-3.xml"));

        // exceptional cases.
        Assertions.assertNull(ResourceFileFinder.find((String [])null));
        Assertions.assertNull(ResourceFileFinder.find(""));
        Assertions.assertNull(ResourceFileFinder.find(" "));
        Assertions.assertNull(ResourceFileFinder.find("", " "));
        Assertions.assertNull(ResourceFileFinder.find(" ", " "));
    }
}
