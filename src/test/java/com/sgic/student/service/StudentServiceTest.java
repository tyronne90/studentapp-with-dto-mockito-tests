package com.sgic.student.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sgic.student.entity.Student;
import com.sgic.student.repo.StudentRepo;
import com.sgic.student.service.impl.StudentServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
	@Mock
	private StudentRepo repo;
	
	@InjectMocks
	private StudentServiceImpl service;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTStudent(){
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("jane", 23));
		when(repo.findAll()).thenReturn(studentList);
		
		List<Student> result = service.getAllStudent();
		assertEquals(1, result.size());
	}
	
	@Test
	public void testGetStudentById(){
		Student student = new Student("Jane", 23);
		when(repo.findStudentById(1L)).thenReturn(student);
		Student result = service.findOneStudent(1L);
		assertEquals("Jane", result.getName());
		assertEquals(23, result.getAge());
	}
	
	@Test
	public void testSaveStudent(){
		Student student = new Student(1L, "jane", 23);
		when(repo.save(student)).thenReturn(student);
		Student result = service.saveStudent(student);

		assertEquals("jane", result.getName());
		assertEquals(23, result.getAge());
	}
	
	@Test
	public void testDeleteStudent(){
		Student student = new Student(1L, "jane", 23);
		service.deleteStudent(1L);
        verify(repo, times(1)).deleteById(student.getId());
	}
	
}
