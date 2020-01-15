package com.luv2code.hibernate.hw.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			int employeeId = 1;

			// now get a new session and start transaction
			// 只要重寫一個交易就要寫一次這段
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + employeeId);

			// 拿取student id並傳回
			Employee myEmployee = session.get(Employee.class, employeeId);

			// delete the student
			 System.out.println("Deleting employee: " + myEmployee);
			 session.delete(myEmployee);

			// delete student id=2
			System.out.println("Deleting employee id=2");
			session.createQuery("delete from Employee where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
