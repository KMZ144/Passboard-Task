package com.global.computers.repo;

import org.springframework.stereotype.Repository;

import com.global.computers.base.repo.BaseRepo;
import com.global.computers.entity.Computer;
import java.util.List;


@Repository
public interface ComputersRepo extends BaseRepo<Computer, Long> {
	
	
	List<Computer> findByEmpId(long empId);
	
}
