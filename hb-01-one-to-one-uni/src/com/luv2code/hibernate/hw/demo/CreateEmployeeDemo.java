package com.luv2code.hibernate.hw.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
		
			System.out.println("Creating new student object...");
			Employee tempEmployee = new Employee(4, "Kyle", "Yen", "Kl");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee...");
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
		
		
	}

}
