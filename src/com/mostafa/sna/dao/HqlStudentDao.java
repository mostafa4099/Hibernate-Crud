package com.mostafa.sna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Student;

public class HqlStudentDao {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> student = session.createQuery("from Student s where s.lastName='Hossain'").getResultList();
			
			displayStudent(student);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	public static void displayStudent(List<Student> student) {
		for (Student st : student) {
			System.out.println(st);
			System.out.println(st.getFirstName());
		}
	}

}
