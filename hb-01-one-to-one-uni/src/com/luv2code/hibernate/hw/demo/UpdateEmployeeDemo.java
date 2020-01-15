package com.luv2code.hibernate.hw.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory .getCurrentSession();
		
		try {
			
			int employeeId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			System.out.println("Update employee...");
			myEmployee.setFirstName("Tom");
			
			session.getTransaction().commit();
			
			// =====================================================
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update company for all employees");
			
			session.createQuery("update Employee set company='TSMC'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
			
		}finally {
			
			factory.close();
			
			
			
		}
		
		
		
	}
	
	
}
