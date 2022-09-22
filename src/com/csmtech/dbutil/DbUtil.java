package com.csmtech.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.csmtech.entity.Cities;
import com.csmtech.entity.Countries;
import com.csmtech.entity.States;




public class DbUtil {
	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			cfg = new Configuration();		
			cfg.addAnnotatedClass(Countries.class);
			cfg.addAnnotatedClass(States.class);
			cfg.addAnnotatedClass(Cities.class);
			sessionFactory = cfg.buildSessionFactory();
			
		}
		
		
		return sessionFactory;
		
	}

}
