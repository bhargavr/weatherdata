package com.leantaas.community.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactoryHeader  = buildSessionFactoryHeader();

    private static final SessionFactory sessionFactoryContent = buildSessionFactoryContent();

    private static SessionFactory buildSessionFactoryHeader() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").addResource("com/leantaas/community/vo/EightBallDataHeaderVO.hbm.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionFactoryContent() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").addResource("com/leantaas/community/vo/EightBallDataContentVO.hbm.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getHeaderSessionFactory() {
        return sessionFactoryHeader;
    }

    public static void shutdownHeader() {
        getHeaderSessionFactory().close();
    }
    
    public static SessionFactory getContentSessionFactory() {
        return sessionFactoryContent;
    }

    public static void shutdownContent() {
        getContentSessionFactory().close();
    }

}
