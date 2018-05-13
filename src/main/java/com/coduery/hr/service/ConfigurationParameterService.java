package com.coduery.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduery.hr.dao.mysql.model.ConfigurationParameter;
import com.coduery.hr.dao.mysql.repo.ConfigurationParameterRepository;
import com.coduery.hr.service.dto.ConfigurationParameterDto;
import com.coduery.hr.service.mapper.ConfigurationParameterMapper;

import fr.xebia.extras.selma.Selma;

@Service
public class ConfigurationParameterService {

    private final ConfigurationParameterRepository configurationParameterRepository;
    private final ConfigurationParameterMapper mapper = Selma.builder(ConfigurationParameterMapper.class).build();

    @Autowired
    public ConfigurationParameterService(ConfigurationParameterRepository configurationParameterRepository) {
        this.configurationParameterRepository = configurationParameterRepository;
    }

    public ConfigurationParameterDto getConfigurationParameter(String configParameterName) {
        ConfigurationParameter param = configurationParameterRepository.findConfigurationParameterByName(configParameterName);
        return mapper.asConfigurationParameterDto(param);
    }
}
