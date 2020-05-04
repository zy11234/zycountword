package com.example.springmvc.db;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

/**
 * An abstract class to wrap the SQL session.
 * Use this class as base class, implement the performInSession() method.
 *
 * @author bobyuan
 */
public abstract class MyBatisSqlSessionWrapper {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyBatisSqlSessionWrapper.class);

    /**
     * Wrapped in a session, execute the performInSession() method.
     *
     * @return An object that is returned from performInSession() method call.
     */
    public Object execute() {
        Object result = null;
        SqlSession session = null;

        try {
            // open a new SQL session.
            session = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

            // call the virtual method, it is implemented in sub-class.
            result = performInSession(session);

            // commit if everything goes right.
            session.commit();
        } catch (Exception e) {
            // roll back if any error occurred.
            if (session != null) {
                session.rollback();

                // write the error log.
                logger.error("DB rolled back with Exception.", e);
            }

            // re-throw the exception out.
            throw e;
        } finally {
            // close the SQL session.
            if (session != null) {
                session.close();
                session = null;
            }
        }

        // return the result from the virtual method performInSession().
        return result;
    }

    /**
     * This abstract method must be implemented in sub-class, it is to perform the query in SQL session.
     *
     * @param session SqlSession to this context.
     * @return An optional object to be returned from the query.
     */
    protected abstract Object performInSession(SqlSession session);
}
