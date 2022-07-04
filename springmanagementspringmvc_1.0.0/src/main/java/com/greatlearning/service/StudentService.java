package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(int id);
	public void saveStudent(Student student);
	public void deleteStudentById(int id);
	
}
