package com.coduery.hr.dao.mysql.repo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coduery.hr.dao.mysql.model.ConfigurationParameter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationParameterRepositoryTest {

    @Autowired
    private ConfigurationParameterRepository repository;

    @Test
    public void testFindAll() {
        List<ConfigurationParameter> params = repository.findAll();
        for (ConfigurationParameter param : params) {
            System.out.println("id: " + param.getId());
            System.out.println("name: " + param.getParameterName());
            System.out.println("value: " + param.getParameterValue());
        }
        assertTrue(params.size() > 0);
    }

}
