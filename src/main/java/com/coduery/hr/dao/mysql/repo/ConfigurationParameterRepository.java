package com.coduery.hr.dao.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coduery.hr.dao.mysql.model.ConfigurationParameter;

@Repository
public interface ConfigurationParameterRepository extends JpaRepository<ConfigurationParameter, Integer> {

    @Query("SELECT c FROM ConfigurationParameter c WHERE c.parameterName = ?1")
    public ConfigurationParameter findConfigurationParameterByName(@Param("parameterName") String parameterName);
}
