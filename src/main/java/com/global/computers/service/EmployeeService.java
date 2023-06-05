package com.global.computers.service;

import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.computers.base.service.BaseService;
import com.global.computers.entity.Employee;
import com.global.computers.repo.EmployeeRepo;

@Service
public class EmployeeService extends BaseService<Employee, Long> {

	@Autowired
	private EmployeeRepo empRepo;
	
	public Employee findByEmpCode(int code) {
		Employee emp =  empRepo.findByCode(code);
		if (emp==null) throw new NoSuchElementException();
		return emp;
	}
	
	
	@Override
	public Employee insert(Employee emp) {
		generateEmployeeCode(emp);
		return empRepo.save(emp); 
	}
	
	public void generateEmployeeCode(Employee emp) {
	    Random random = new Random();
	    int code;
	    boolean uniqueCodeFound = false;
	    do {
	        code = random.nextInt(9000) + 1000; 
	        Employee existingEmployee = empRepo.findByCode(code);
	        if (existingEmployee == null) {
	            uniqueCodeFound = true;
	        }
	    } while (!uniqueCodeFound);
	    emp.setCode(code);
	}
}
