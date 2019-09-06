package com.sgic.student.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.student.controller.dto.StudentDto;
import com.sgic.student.entity.Student;

@Service
public class StudentConverter {

	// Convert Entity lists to dto
	public List<StudentDto> entityListTODtoList(List<Student> studentList) {
		if (studentList != null) {
			List<StudentDto> listStudentDto = new ArrayList<>();
			for (Student student : studentList) {
				StudentDto studentDto = new StudentDto();
				studentDto.setStudentId(student.getId());
				studentDto.setStudentName(student.getName());
				studentDto.setStudentAge(student.getAge());
				listStudentDto.add(studentDto);
			}
			return listStudentDto;
		}
		return null;
	}

	// Convert Data To Entity
	public Student dtoToEntity(StudentDto studentDto) {
		Student student = new Student();
		if (studentDto != null) {
			student.setId(studentDto.getStudentId());
			student.setName(studentDto.getStudentName());
			student.setAge(studentDto.getStudentAge());
			return student;
		}
		return null;
	}

	// Convert Entity To Data
	public StudentDto entityToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		if (student != null) {
			studentDto.setStudentId(student.getId());
			studentDto.setStudentName(student.getName());
			studentDto.setStudentAge(student.getAge());
			return studentDto;
		}
		return null;
	}

}
