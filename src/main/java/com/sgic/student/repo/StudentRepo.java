package com.sgic.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
	public Student findStudentById(Long id);
}
