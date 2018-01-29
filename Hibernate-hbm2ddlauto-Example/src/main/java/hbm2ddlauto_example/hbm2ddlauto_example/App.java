package hbm2ddlauto_example.hbm2ddlauto_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.otp.hibernate.pojo.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("********* APP ************");
		
		Configuration configuration            = new Configuration().configure("hibernate.cfg.xml");		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());		
		SessionFactory factory                 = configuration.buildSessionFactory(builder.build());		

		Session session 					   = factory.openSession();
		Transaction transaction                = session.beginTransaction();
						
		Student student = new Student();
		student.setStudentName("Nombre app");
		student.setAddress("Direccion app");							
		session.save(student);
		
		transaction.commit();
		session.flush();
		session.close();
	}
}
