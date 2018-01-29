package com.xavi.principal;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.otp.hibernate.pojo.Student;

public class Main {

	public static void main(String[] args) {
		System.out.println("********* MAIN ************");
		
		Configuration configuration            = new Configuration().configure("hibernate.cfg.xml");		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());	
		SessionFactory factory                 = configuration.buildSessionFactory(builder.build());

		Session session                        = factory.openSession();		
		Transaction transaction                = session.beginTransaction();
		
		Student student = new Student();
		student.setStudentName("Nombre main");
		student.setAddress("Direccion main");
		session.save(student);
		
		Student student2 = new Student();
		student2.setStudentName("Nombre main 2");	
		
		student2.setAddress("Direccion main 2");
		session.save(student2);
		
		transaction.commit();
		session.flush();
		session.close();
		System.out.println("Transaccion completada !");
	}

}
