package com.cbd.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateAnnotationUtil {
	private static Configuration cfg;
	private static SessionFactory sf;
	private static Session session;
	static{
		cfg=new AnnotationConfiguration().configure();
		sf=cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
//		if(session==null)
			session=sf.openSession();
//		else session=sf.getCurrentSession();
		return session;
	}
}
