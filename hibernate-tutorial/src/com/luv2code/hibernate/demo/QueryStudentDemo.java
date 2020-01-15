package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			

			// start a transaction
			session.beginTransaction();

			// query students
			// Hibernate5.2 + UPDATE Replace "list()" with "getResultList()"
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			// literal寫法
			displayStudents(theStudents);
			
			// query students: lastName='Lu'
			// Hibernate5.2 + UPDATE Replace "list()" with "getResultList()"
			theStudents = session.createQuery("from Student s where s.lastName='Lu'").list();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Lu");
			displayStudents(theStudents);
			
			// query students: lastName='Lu' OR firstName='Thomas'
			theStudents = 
					session.createQuery("from Student s where s.lastName='Lu' OR s.firstName='Thomas'").list();		
			
			// display the students
			System.out.println("\n\nStudents who have last name of Lu OR first name Thomas");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = 
					session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			
			// display the students
			System.out.println("\n\nStudents who email ends with gmail.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
