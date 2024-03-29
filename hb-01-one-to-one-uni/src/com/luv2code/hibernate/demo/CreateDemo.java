package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			Instructor tempInstructor = new Instructor("Thomas", "Lu", "luchienlin1994@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
						"http://www.luchienlin.com/youtube",
						"love Java");
			
			// associated the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			session.save(tempInstructor);
					
			// start a transaction
			session.beginTransaction();

		
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
