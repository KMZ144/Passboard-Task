package com.global.computers.entity;

import com.global.computers.base.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Computer extends BaseEntity<Long> {
	
	
	
	@NotNull(message = "mac address required")
	private String macAddress;
	
	@NotNull(message = "ip address required")
	private String ipAddress;
	
	@NotNull(message = "name is required")
	private String name;
	
	@ManyToOne()
	private Employee emp;
	
	private String description;

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

		
}
