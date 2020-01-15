package com.luv2code.hibernate.hw.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee(5, "Thomas", "Lu", "TSMC");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Saved employee Generated id: " + tempEmployee.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting empolyee with id: " + tempEmployee.getId());
			
			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
			
			System.out.println("Get Complete: " + myEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
			
		}finally {
			factory.close();
		}

	}

}
