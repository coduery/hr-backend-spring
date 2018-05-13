package com.coduery.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduery.hr.service.ConfigurationParameterService;
import com.coduery.hr.service.dto.ConfigurationParameterDto;

@Controller
@RequestMapping(value = "/Configuration")
public class ConfigurationParameterController {

    private final ConfigurationParameterService service;

    public ConfigurationParameterController(ConfigurationParameterService service) {
        this.service = service;
    }

    @GetMapping(value = "/Parameter")
    @ResponseBody
    // Example call http://localhost:8081/Configuration/Parameter?param_name=test_param
    public ConfigurationParameterDto getConfigurationParameter(@RequestParam ("param_name") String configParameterName) {
        return service.getConfigurationParameter(configParameterName);
    }
}
