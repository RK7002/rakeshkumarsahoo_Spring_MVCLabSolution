package com.greatlearning.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;

import com.greatlearning.entity.Student;

@Repository
public class StudentDAOImplementation implements StudentDAO{
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public StudentDAOImplementation(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Student> findAll() {
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Override
	public Student findById(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		transaction.commit();
		return student;
	}

	@Override
	public void saveStudent(Student student) {
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
	}

	@Override
	public void deleteStudentById(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
	}

}

