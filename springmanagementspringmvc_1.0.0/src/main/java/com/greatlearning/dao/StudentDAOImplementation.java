package com.greatlearning.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import com.greatlearning.entity.Student;

@Repository
public class StudentDAOImplementation implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Student> findAll() {
		Session session=sessionFactory.getCurrentSession();
		Query<Student> query = session.createQuery("from Student",Student.class);
		List<Student> students=query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public Student findById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		session.delete(student);
	}

}

