package com.walmart.SQL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController)
                .build();
    }

    @Test
    public void testStudentController() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/sayhello")
        ).andExpect(MockMvcResultMatchers.content().string("Hello"));
    }
}