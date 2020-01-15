package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// create a student object
			System.out.println("Creating new student object...");
			// Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			// System.out.println(tempStudent);		
			// session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			// MY NEW CODE
			// Console顯示PrimaryKey ID是...
			// System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			// 只要重寫一個交易就要寫一次這段
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			// System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			// 拿取student id並傳回
			// Student myStudent = session.get(Student.class, tempStudent.getId());
			
			// System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
