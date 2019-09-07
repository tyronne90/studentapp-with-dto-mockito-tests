package com.sgic.student.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sgic.student.StudentAppWithDtoApplication;
import com.sgic.student.controller.dto.StudentDto;
import com.sgic.student.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StudentAppWithDtoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTestForStudentController {
	
private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void verifyAllStudentList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/students").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(7))).andDo(print());
	}
	
	@Test
	public void verifyStudentById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/student/1")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.studentId").exists())
		.andExpect(jsonPath("$.studentName").exists())
		.andExpect(jsonPath("$.studentAge").exists())
		.andExpect(jsonPath("$.studentId").value(1))
		.andExpect(jsonPath("$.studentName").value("Jane"))
		.andExpect(jsonPath("$.studentAge").value(25))
		.andDo(print());
	}
	
//	@Test
//	public void verifySaveToDo() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/student/")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content("{\"studentName\" : \"Jack\", \"studentAge\" : 22 }")
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.studentId").exists())
//		.andExpect(jsonPath("$.studentName").exists())
//		.andExpect(jsonPath("$.studentAge").exists())
//		.andExpect(jsonPath("$.studentName").value("Jane"))
//		.andExpect(jsonPath("$.studentAge").value(25))
//		.andDo(print());
//	}
	
//	@Test
//	public void verifyUpdateToDo() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.put("/api/student/")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content("{ \"studentId\": 13, \"studentName\" : \"New ToDo Text\", \"studentAge\" : 22 }")
//        .accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.studentId").exists())
//		.andExpect(jsonPath("$.studentName").exists())
//		.andExpect(jsonPath("$.studentAge").exists())
//		.andExpect(jsonPath("$.studentId").value(1))
//		.andExpect(jsonPath("$.studentName").value("New ToDo Text"))
//		.andExpect(jsonPath("$.studentAge").value(22))
//		.andDo(print());
//	}
	
	
}
