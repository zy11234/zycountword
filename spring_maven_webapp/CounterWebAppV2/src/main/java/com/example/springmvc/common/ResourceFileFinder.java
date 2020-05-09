package com.example.springmvc.common;

import java.net.URL;

import org.apache.commons.lang3.StringUtils;

public class ResourceFileFinder {
    /**
     * Test if given resource file exists or not.
     *
     * @param resFile The filename of the resource file.
     * @return True if exist, False if could not be found.
     */
    private static boolean isResourceFileExists(String resFile) {
        if (StringUtils.isBlank(resFile)) {
            // always return false if given a blank filename.
            return false;
        } else {
            // check availability as resource.
            URL url = ResourceFileFinder.class.getResource("/" + resFile);
            return url != null;
        }
    }

    /**
     * Find the filename that is available in resource.
     *
     * @param resFileNames The variable arguments of filenames.
     * @return The first filename been found, or null if not found.
     */
    public static String find(String... resFileNames) {
        if (resFileNames != null) {
            // return the name if found.
            for (String resfn : resFileNames) {
                if (isResourceFileExists(resfn)) {
                    return resfn;
                }
            }
        }

        // if not found.
        return null;
    }
}
