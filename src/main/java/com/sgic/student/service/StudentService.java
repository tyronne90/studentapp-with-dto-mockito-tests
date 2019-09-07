package com.sgic.student.service;

import java.util.List;

import com.sgic.student.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudent();
	public Student saveStudent(Student student);
	public Student findOneStudent(Long id);
	public Student updateStudent(Student student);
	public Student deleteStudent(Long id);
	
}
