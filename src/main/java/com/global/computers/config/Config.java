package com.global.computers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.computers.entity.Computer;
import com.global.computers.entity.Employee;
import com.global.computers.service.ComputerService;
import com.global.computers.service.EmployeeService;

@Component
public class Config implements  CommandLineRunner {

	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setName("kareem");
		emp.setEmpCode(3000);
		employeeService.insert(emp);
		
		Employee emp2 = new Employee();
		emp2.setName("kareem");
		emp2.setEmpCode(3001);
		employeeService.insert(emp2);
		
		Computer comp1=new Computer();
		comp1.setDescription("test Desc");
		comp1.setIpAddress("192.168.1.10");
		comp1.setMacAddress("test mac address1");
		comp1.setName("comp1");
		comp1.setEmp(emp);
		computerService.insert(comp1);
		
		Computer comp2=new Computer();
		comp2.setDescription("test Desc2");
		comp2.setIpAddress("192.168.1.11");
		comp2.setMacAddress("test mac address2");
		comp2.setName("comp2");
		comp2.setEmp(emp2);
		computerService.insert(comp2);
		
	}

}
