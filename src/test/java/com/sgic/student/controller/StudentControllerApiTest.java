package com.sgic.student.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.student.controller.dto.StudentDto;
import com.sgic.student.controller.mapper.StudentMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
//@ContextConfiguration(classes= {StudentAppWithDtoApplication.class})
public class StudentControllerApiTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StudentMapper mapper;
	
	@Test
	public void homeTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "Hello";
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void getAllStudent() throws Exception {
		List<StudentDto> studentList = new ArrayList<>();
		StudentDto stOne = new StudentDto(1L, "name", 23);
		StudentDto sttwo = new StudentDto(2L, "name", 23);
		studentList.add(stOne);
		studentList.add(sttwo);

		when(mapper.getAllStudent()).thenReturn(studentList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/students").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{'studentId':1,'studentName':'name','studentAge':23},{'studentId':2,'studentName':'name','studentAge':23}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	
	@Test
	public void saveStudentApiTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
				.content(asJsonString(new StudentDto("jim", 22)))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Test
	public void getOneStudent() throws Exception {
		StudentDto stOne = new StudentDto(12L, "name", 23);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/student/{id}", stOne.getStudentId()).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
	
	
	@Test
	public void deleteStudent() throws Exception {
		StudentDto stOne = new StudentDto(12L, "name", 23);
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/{id}", stOne.getStudentId()).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
	
		
	
	
}
