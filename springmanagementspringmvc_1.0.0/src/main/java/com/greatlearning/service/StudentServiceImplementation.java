package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.StudentDAO;
import com.greatlearning.entity.Student;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
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
