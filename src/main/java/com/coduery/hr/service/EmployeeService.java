package com.coduery.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduery.hr.dao.oracle.model.Employee;
import com.coduery.hr.dao.oracle.repo.EmployeeRepository;
import com.coduery.hr.service.dto.EmployeeDto;
import com.coduery.hr.service.mapper.EmployeeMapper;

import fr.xebia.extras.selma.Selma;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = Selma.builder(EmployeeMapper.class).build();

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto getEmployeeByEmailAddress(String emailAddress) {
        if (emailAddress != null && !emailAddress.trim().isEmpty()) {
            Employee employee = employeeRepository.findByEmailAddress(emailAddress);
            return employeeMapper.asEmployeeDto(employee);
        }
        return null;
    }
}
