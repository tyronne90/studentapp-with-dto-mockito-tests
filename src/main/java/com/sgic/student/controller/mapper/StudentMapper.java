package com.sgic.student.controller.mapper;

import java.util.List;

import com.sgic.student.controller.dto.StudentDto;


public interface StudentMapper {
	public List<StudentDto> getAllStudent();
	public Object saveStudent(StudentDto studentDto);
	public StudentDto findOneStudent(Long id);
	public Object updateStudent(StudentDto studentDto);
	public Object deleteStudent(Long id);
}
