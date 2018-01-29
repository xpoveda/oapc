package com.openwebinars.hibernate.hibernatejpaonetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Asociaciones OneToMany unidireccionales
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToManyUni");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		Person person = new Person("Pepe");
		Phone phone1 = new Phone("954000000");
		Phone phone2 = new Phone("600000000");

		person.getPhones().add(phone1);
		person.getPhones().add(phone2);
		em.persist(person);
		em.flush();

		person.getPhones().remove(phone1);
		

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();
		
	}
}
