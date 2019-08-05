package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Student;

public class UpdateStudentDao {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student student= session.get(Student.class, 26);
			
			System.out.println(student);
			System.out.println(student.getLastName());
			
			student.setFirstName("Kamim");
			
			session.getTransaction().commit();
			
			System.out.println("First update done.");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set firstName='Rahim' where id =26").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Second update done.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
