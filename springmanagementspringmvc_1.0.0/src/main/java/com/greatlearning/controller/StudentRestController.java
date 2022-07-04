package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Student;
import com.greatlearning.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudent(Model model) {
		List<Student> students = studentService.findAll();

		model.addAttribute("students", students);
		return "listStudent";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addStudent";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "addStudent";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else {
			student = new Student(name, department, country);
		}
		studentService.saveStudent(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteStudentById(id);
		return "redirect:/student/list";
	}
}
