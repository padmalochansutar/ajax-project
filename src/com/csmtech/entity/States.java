package com.csmtech.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class States implements Serializable {
	@Id
	@Column(name="state_id")
	private Integer stateId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="country_id")
	private Integer countryId;
	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "States [stateId=" + stateId + ", name=" + name + ", countryId=" + countryId + "]";
	}

	
}
