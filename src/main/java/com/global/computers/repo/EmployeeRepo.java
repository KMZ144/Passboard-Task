package com.global.computers.repo;

import org.springframework.stereotype.Repository;

import com.global.computers.base.repo.BaseRepo;
import com.global.computers.entity.Employee;

@Repository
public interface EmployeeRepo extends BaseRepo<Employee, Long> {
	
	Employee findByEmpCode(int code);

}
