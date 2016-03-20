package com.my.app.workflow.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/*-context.xml"})
@WebAppConfiguration
public class NsControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testInstantiage() throws Exception {
		MvcResult result = this.mockMvc.perform(
				post("/ns/instantiate").contentType(MediaType.APPLICATION_JSON_VALUE)
			)
			.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

}
