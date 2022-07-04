package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.dao.StudentDAO;
import com.greatlearning.entity.Student;

public class StudentServiceImplementation implements StudentService{
	
	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImplementation(StudentDAO studentDAO) {
		this.studentDAO=studentDAO;
	}
	
	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDAO.deleteStudentById(id);
	}

}
