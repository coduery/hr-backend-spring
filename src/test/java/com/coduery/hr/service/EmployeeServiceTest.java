package com.coduery.hr.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coduery.hr.service.EmployeeService;
import com.coduery.hr.service.dto.EmployeeDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void getEmployeeByEmailAddressTest() {

        EmployeeDto employeeDto = employeeService.getEmployeeByEmailAddress("JMURMAN");
        System.out.println("Employee firstname: " + employeeDto.getFirstName());
        assertTrue(employeeDto != null & employeeDto.getFirstName() != null & !employeeDto.getFirstName().isEmpty());
    }

}
