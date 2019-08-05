package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Student;

public class DeleteStudentDao {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student student= session.get(Student.class, 27);
			
			System.out.println(student);
			System.out.println(student.getLastName());
			
			session.delete(student);
			
			session.getTransaction().commit();
			
//			System.out.println("deleted.");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id =27").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Second deletion done.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
