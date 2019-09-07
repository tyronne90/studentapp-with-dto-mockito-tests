package com.sgic.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.student.controller.dto.StudentDto;
import com.sgic.student.controller.mapper.StudentMapper;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentMapper mapper;

	@GetMapping("/")
	public String home() {
		return "Hello";
	}

	@PostMapping("/student")
	public Object saveStudent(@Valid @RequestBody StudentDto studentDto) {
		return mapper.saveStudent(studentDto);
	}

	@GetMapping("/students")
	public List<StudentDto> getAllStudent() {
		return mapper.getAllStudent();
	}

	@GetMapping("/student/{id}")
	public StudentDto getOneStudent(@PathVariable("id") Long id) {
		return mapper.findOneStudent(id);
	}

	@PutMapping("/student")
	public Object updateStudent(@Valid @RequestBody StudentDto studentDto) {
		return mapper.updateStudent(studentDto);
	}

	@DeleteMapping("/student/{id}")
	public Object deleteStudent(@PathVariable("id") Long id) {
		return mapper.deleteStudent(id);
	}

}
