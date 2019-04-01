package com.luv2code.springdemo.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable exc) {
            System.err.println("\n\nInitial SessionFactory creation failed " + exc);
            throw new ExceptionInInitializerError(exc);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
