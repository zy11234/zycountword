package com.example.springmvc.common;

import org.junit.Assert;
import org.junit.Test;

public class ResourceFileFinderTest {
    @Test
    public void testBasicUsage() {
        Assert.assertEquals("logback-test.xml", ResourceFileFinder.find("logback-test.xml"));
        Assert.assertEquals("logback-test.xml", ResourceFileFinder.find("logback-test.xml", "logback.xml"));

        Assert.assertEquals("logback-test.xml", ResourceFileFinder.find("no-such-file.xml", "logback-test.xml"));
        Assert.assertEquals("logback.xml", ResourceFileFinder.find("no-such-file.xml", "logback.xml"));

        Assert.assertNull(ResourceFileFinder.find("no-such-file-1.xml"));
        Assert.assertNull(ResourceFileFinder.find("no-such-file-1.xml", "no-such-file-2.xml"));
        Assert.assertNull(ResourceFileFinder.find("no-such-file-1.xml", "no-such-file-2.xml", "no-such-file-3.xml"));

        // exceptional cases.
        Assert.assertNull(ResourceFileFinder.find((String [])null));
        Assert.assertNull(ResourceFileFinder.find(""));
        Assert.assertNull(ResourceFileFinder.find(" "));
        Assert.assertNull(ResourceFileFinder.find("", " "));
        Assert.assertNull(ResourceFileFinder.find(" ", " "));
    }
}
