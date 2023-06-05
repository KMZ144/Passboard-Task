package com.global.computers.entity;

import com.global.computers.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Employee extends BaseEntity<Long> {
	

	@Column(unique = true)
	private int code;
	
	private String name;

	public int getCode() {
		return  code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
