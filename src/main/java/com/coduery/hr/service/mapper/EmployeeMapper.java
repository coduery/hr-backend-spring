package com.coduery.hr.service.mapper;

import com.coduery.hr.dao.oracle.model.Employee;
import com.coduery.hr.service.dto.EmployeeDto;

// See Selma Mapper at http://www.selma-java.org, Map JPA entities to (DTO) Data Transfer Objects
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface EmployeeMapper {

    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    EmployeeDto asEmployeeDto(Employee employee);

    @Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    Employee asEmployee(EmployeeDto employeeDto);
}
