package com.example.dbtest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbtest.dto.Student;
import com.example.dbtest.service.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private final StudentRepository studentRepository;
	
	
	
	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentRepository.findById(id).orElse(null);	
	}
	
	@GetMapping("/")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/")
	public Student createStudent(@RequestBody Student student) {
		//System.out.println(student.toString());
		//return student;
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
		Student toBeUpdated = studentRepository.findById(id).orElse(new Student());
		toBeUpdated.setDept(student.getDept());
		toBeUpdated.setName(student.getName());
		return studentRepository.save(toBeUpdated);
	}
	
	@DeleteMapping("/{id}")
	public Boolean deleteStudent(@PathVariable int id) {
		try {
			studentRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
}
