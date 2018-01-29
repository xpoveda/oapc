package com.openwebinars.hibernate.concurrency.optimistic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

/**
 * Control de concurrencia (optimista)
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class AppOpti {

	static EntityManagerFactory emf;

	static EntityManager em;

	public static void main(String[] args) {

		// Configuramos el EMF a través de la unidad de persistencia
		emf = Persistence.createEntityManagerFactory("Concurrencia");

		// Generamos un EntityManager
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		AnotherUserAccount anotherUserAccount = new AnotherUserAccount();
		anotherUserAccount.setId(1);
		anotherUserAccount.setBalance(600);
		anotherUserAccount.setName("Luismi");
		
		em.persist(anotherUserAccount);
		
		em.getTransaction().commit();
		
				
		cambioDeSaldoEnHilo(700, 1);
		cambioDeSaldoEnHilo(800, 1);
		
		System.out.println("User balance: " + anotherUserAccount.getBalance() );
		
		// Cerramos el EntityManager
		//em.close();
		//emf.close();

	}
	
	public static void cambioDeSaldoEnHilo(final double nuevoBalance, final long sleepTime) {
		new Thread(new Runnable() {

			@Override
			public void run() {
								
				em.getTransaction().begin();

				AnotherUserAccount userAccount = em.find(AnotherUserAccount.class, 1);
				userAccount.setBalance(nuevoBalance);
				em.persist(userAccount);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				em.flush();
				//em.refresh(userAccount);
				em.getTransaction().commit();
				
				System.out.println(userAccount);
			}
			
			
		}).start();
	}


}
