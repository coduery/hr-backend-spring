package com.coduery.hr.dao.mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the configuration_parameter database table.
 * 
 */
@Entity
@Table(name="configuration_parameter")
@NamedQuery(name="ConfigurationParameter.findAll", query="SELECT c FROM ConfigurationParameter c")
public class ConfigurationParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="parameter_name")
	private String parameterName;

	@Column(name="parameter_value")
	private String parameterValue;

	public ConfigurationParameter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return this.parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

}