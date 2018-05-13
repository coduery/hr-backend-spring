package com.coduery.hr.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.coduery.hr.service.EmployeeService;
import com.coduery.hr.service.dto.EmployeeDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService mockEmployeeService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void getEmployeeByEmailAddressTest() throws Exception {
        EmployeeDto expectedEmployee = new EmployeeDto();
        expectedEmployee.setEmployeeId(112);
        expectedEmployee.setEmail("JMURMAN");
        expectedEmployee.setFirstName("Jose Manuel");
        expectedEmployee.setLastName("Urman");
        expectedEmployee.setPhoneNumber("515.124.4469");

        when(mockEmployeeService.getEmployeeByEmailAddress("JMURMAN")).thenReturn(expectedEmployee);
        mockMvc.perform(get("/Employee/EmailAddress?emailAddress=JMURMAN"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'employeeId':112,'email':'JMURMAN','firstName':'Jose Manuel','lastName':'Urman','phoneNumber':'515.124.4469'}"));
    }

}
