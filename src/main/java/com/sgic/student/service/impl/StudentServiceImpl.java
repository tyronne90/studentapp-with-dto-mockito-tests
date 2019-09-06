package com.sgic.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.student.entity.Student;
import com.sgic.student.repo.StudentRepo;
import com.sgic.student.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Object saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student findOneStudent(Long id) {
		return studentRepo.findStudentById(id);
	}

	@Override
	public Object updateStudent(Student student) {
		if(student.getId()!=null) {
			studentRepo.save(student);
		}
		return null;
	}

	@Override
	public Object deleteStudent(Long id) {
		if(id!=null)
			studentRepo.deleteById(id);
		return null;
	}

}
