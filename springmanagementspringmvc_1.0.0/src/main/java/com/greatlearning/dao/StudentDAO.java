package com.greatlearning.dao;

import java.util.List;

import com.greatlearning.entity.Student;

public interface StudentDAO {
	
	public List<Student> findAll();
	public Student findById(int id);
	public void saveStudent(Student student);
	public void deleteStudentById(int id);
	
}
