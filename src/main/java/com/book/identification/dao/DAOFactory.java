package com.book.identification.dao;


public abstract class DAOFactory {
	 private static Object initLock = new Object();   
	   
	    private static DAOFactory factory = null;   
	   
	    public static DAOFactory getInstance() {   
	        if (factory == null) {   
	            synchronized (initLock) {   
	                if (factory == null) {   
	                        factory = (DAOFactory) new HibernateDAOFactory();   
	                }   
	            }   
	        }   
	        return factory;   
	    }   
	   
	    public abstract VolumeDAO getVolumeDAO();   
	    public abstract VolumeInfoDAO getVolumeInfoDAO();   
	    public abstract CategoryDAO getCategoryDAO();   
}
