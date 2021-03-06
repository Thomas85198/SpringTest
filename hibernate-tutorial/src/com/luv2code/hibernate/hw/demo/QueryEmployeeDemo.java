package com.luv2code.hibernate.hw.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
												.addAnnotatedClass(Employee.class)
												.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		
		List<Employee> theEmployees = session.createQuery("from Employee").list();
		
		displayEmployees(theEmployees);
		
		theEmployees = session.createQuery("from Employee s where s. lastName = 'Lu'").list();
		
		System.out.println("\n\nEmployees who have last name of Lu");
		displayEmployees(theEmployees);
		
		theEmployees = 
				session.createQuery("from Student s where s.lastName LIKE 'L%'").list();
		
		System.out.println("\n\nEmployees who have last name ends with of L");
		displayEmployees(theEmployees);
		
		session.getTransaction().commit();
		System.out.println("Done!");
		
		
	}finally {
		factory.close();
	}
}

	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee tempEmployee: theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
