package com.example.readinglist;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.readinglist.web.ReadingListController;

import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ReadingListController.class)
@WebAppConfiguration
public class MockMvcWebTests {

	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;

	@Before
	public void setUpMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void homePage() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/test1"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("readingList"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("bokks"))
			.andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
	}
	
}
