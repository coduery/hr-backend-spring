package com.coduery.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduery.hr.service.EmployeeService;
import com.coduery.hr.service.dto.EmployeeDto;

@Controller
@RequestMapping(value = "/Employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Example call, http://localhost:8081/Employee/EmailAddress?emailAddress=JMURMAN
    //@RequestMapping(value = "/EmailAddress", method = RequestMethod.GET, produces = "application/json")
    // With Spring 4.3 can use anotations specific to the Http method, as shown below, instead of RequestMapping
    @GetMapping(value = "/EmailAddress", produces = "application/json")
    @ResponseBody
    // public EmployeeDto getEmployeeByEmailAddress(@RequestParam (value = "emailAddress") String emailAddress) {
    // If the name of the method argument matches the name of the path variable exactly, then this can be
    // simplified by using @PathVariable with no value as shown below.
    public EmployeeDto getEmployeeByEmailAddress(@RequestParam String emailAddress) {
        return employeeService.getEmployeeByEmailAddress(emailAddress);
    }
}
