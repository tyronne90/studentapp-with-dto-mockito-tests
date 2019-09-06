package com.sgic.student.service;

import java.util.List;

import com.sgic.student.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudent();
	public Object saveStudent(Student student);
	public Student findOneStudent(Long id);
	public Object updateStudent(Student student);
	public Object deleteStudent(Long id);
	
}
