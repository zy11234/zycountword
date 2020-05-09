package com.example.springmvc.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.LoggerFactory;

import com.example.springmvc.common.ResourceFileFinder;

/**
 * Static factory to initialize and get the MyBatis SqlSessionFactory object.
 *
 * @author bobyuan
 */
public class MyBatisSqlSessionFactory {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyBatisSqlSessionFactory.class);
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * Get the MyBatis configuration filename available in classpath:
     * 1. "mybatis-config-test.xml" or ""mybatis-config.test.xml" for development/testing
     * 2. "mybatis-config.xml" for production
     *
     * @return The available configuration file name.
     */
    private static String getMyBatisConfigFile() {
        final String[] CONFIG_FILES = { "mybatis-config-test.xml", "mybatis-config.test.xml" };
        final String CONFIG_DEFAULT_FILENAME = "mybatis-config.xml";

        // Search for the available configuration file in order.
        String confFile = ResourceFileFinder.find(CONFIG_FILES);
        if (confFile != null) {
            // Return the filename been found.
            return confFile;
        }

        // Return the default.
        return CONFIG_DEFAULT_FILENAME;
    }

    static {
        InputStream ins = null;
        try {
            // Find the configuration file.
            String confFileName = getMyBatisConfigFile();
            logger.info("MyBatis is configured by resource file: " + confFileName);

            // Initialize MyBatis.
            ins = Resources.getResourceAsStream(confFileName);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
        } catch (IOException e1) {
            // write the error log.
            logger.error("MyBatis initialize failure.", e1);
        } finally {
            // clean up.
            if (ins != null) {
                try {
                    ins.close();
                    ins = null;
                } catch (IOException e2) {
                    logger.warn("Resource cleanup with error (can be ignored).", e2);
                }
            }
        }
    }

    /**
     * Get the SqlSessionFactory object.
     *
     * @return The SqlSessionFactory object.
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
