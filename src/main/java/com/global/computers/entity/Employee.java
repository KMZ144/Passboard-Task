package com.global.computers.entity;

import com.global.computers.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Employee extends BaseEntity<Long> {
	

	@Column(unique = true)
	private int empCode;
	
	private String name;

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
