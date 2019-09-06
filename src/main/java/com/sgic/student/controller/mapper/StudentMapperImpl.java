package com.sgic.student.controller.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.student.controller.converter.StudentConverter;
import com.sgic.student.controller.dto.StudentDto;
import com.sgic.student.entity.Student;
import com.sgic.student.service.StudentService;

@Service
public class StudentMapperImpl implements StudentMapper{

	@Autowired
	StudentService service;
	
	@Autowired
	StudentConverter converter;

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> studentList = service.getAllStudent();
		return converter.entityListTODtoList(studentList);
	}

	@Override
	public Object saveStudent(StudentDto studentDto) {
		return service.saveStudent(converter.dtoToEntity(studentDto));
	}

	@Override
	public StudentDto findOneStudent(Long id) {
		Student student = service.findOneStudent(id);
		return converter.entityToDto(student);
	}

	@Override
	public Object updateStudent(StudentDto studentDto) {
		return service.updateStudent(converter.dtoToEntity(studentDto));
	}

	@Override
	public Object deleteStudent(Long id) {
		service.deleteStudent(id);
		return null;
	}
	
	
}
