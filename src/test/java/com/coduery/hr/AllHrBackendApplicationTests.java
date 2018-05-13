package com.coduery.hr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.coduery.hr.controller.EmployeeControllerTest;
import com.coduery.hr.dao.mysql.repo.ConfigurationParameterRepositoryTest;
import com.coduery.hr.dao.oracle.repo.EmployeeRepositoryTest;
import com.coduery.hr.service.EmployeeServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ ConfigurationParameterRepositoryTest.class,
                EmployeeControllerTest.class,
                EmployeeRepositoryTest.class,
                EmployeeServiceTest.class
})
public class AllHrBackendApplicationTests {

}
