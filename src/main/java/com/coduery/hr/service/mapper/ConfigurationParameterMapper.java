package com.coduery.hr.service.mapper;

import com.coduery.hr.dao.mysql.model.ConfigurationParameter;
import com.coduery.hr.service.dto.ConfigurationParameterDto;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface ConfigurationParameterMapper {

    @Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    ConfigurationParameterDto asConfigurationParameterDto(ConfigurationParameter configurationParameter);
}
