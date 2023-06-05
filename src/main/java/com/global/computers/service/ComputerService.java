package com.global.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.global.computers.base.service.BaseService;
import com.global.computers.entity.Computer;
import com.global.computers.entity.Employee;
import com.global.computers.repo.ComputersRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComputerService extends BaseService<Computer, Long> {

	@Autowired
	private ComputersRepo computerRepo;

	@Autowired
	private EmployeeService empService;


	public List<Computer> findComputersByEmpId(long empId) {
		return computerRepo.findByEmpId(empId);
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
