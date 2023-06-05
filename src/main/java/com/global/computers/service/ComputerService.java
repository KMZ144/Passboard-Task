package com.global.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import com.global.computers.base.service.BaseService;
import com.global.computers.entity.Computer;
import com.global.computers.entity.Employee;
import com.global.computers.repo.ComputersRepo;

import jakarta.validation.Valid;


@Service
public class ComputerService extends BaseService<Computer, Long> {

	@Autowired
	private ComputersRepo computerRepo;

	@Autowired
	private EmployeeService empService;

	 
	
	public List<Computer> findComputersByEmpId(long empId) {
		List<Computer> computers =  computerRepo.findByEmpId(empId);
		if (computers==null) throw new NoSuchElementException("emp id is not found");
		return computers;
	}
	
	@Override
	public Computer insert(Computer entity) {
		Employee emp= entity.getEmp();		
		if ((emp !=null && empService.findById(emp.getId()) != null)||emp==null) {
			return computerRepo.save(entity);
		}
		throw new NoSuchElementException("emp id is not found");
	}


	public Computer removeComputerFromEmployee(long computerId) {
		Computer computer = findById(computerId);
		computer.setEmp(null);
		return computerRepo.save(computer);
	}

	public Computer addComputerToEmployee(long computerId, long empId) {
		Computer computer = findById(computerId);
		Employee emp = empService.findById(empId);
		computer.setEmp(emp);
		return computerRepo.save(computer);
	}
	
	public boolean checkComputersAssignedToEmp(long id) {
		if (findComputersByEmpId(id).size() >= 3) {
			return true;
		}
		return false ;
	}
	

}
