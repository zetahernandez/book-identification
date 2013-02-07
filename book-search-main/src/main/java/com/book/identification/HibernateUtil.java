package com.book.identification;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateUtil {
 
	  private static SessionFactory sessionFactory;
	    private static ServiceRegistry serviceRegistry;

	    static
	    {
	        try
	        {
	            Configuration configuration = new Configuration().configure();

	            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        }
	        catch (HibernateException he)
	        {
	            System.err.println("Error creating Session: " + he);
	            throw new ExceptionInInitializerError(he);
	        }
	    }

	    public static synchronized SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    } 
	    
	    public static synchronized Session getCurrentSession(){
	    	return getSessionFactory().openSession();
	    }
}