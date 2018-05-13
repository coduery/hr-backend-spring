package com.coduery.hr.dao.oracle.repo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coduery.hr.dao.oracle.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testFindAll() {
        List<Employee> params = repository.findAll();
        for (Employee param : params) {
            System.out.println("id: " + param.getEmployeeId());
        }
        assertTrue(params.size() > 0);
    }

}
