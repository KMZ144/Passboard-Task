package com.global.computers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.global.computers.entity.Employee;
import com.global.computers.service.ComputerService;
import com.global.computers.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ComputerService computerService;
	
	@GetMapping("")
	public ResponseEntity<List<Employee>>  findAll() {
		return ResponseEntity.ok(empService.findAll()) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable long id) {
		return ResponseEntity.ok(empService.findById(id)) ;
	}
	
	@PostMapping("")
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee emp){
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.insert(emp));
	}
	
	@DeleteMapping("/computers/{computerId}")
	public ResponseEntity<?> removeCompputerFromEmployee(@PathVariable long computerId) {
		computerService.removeComputerFromEmployee(computerId);
		return ResponseEntity.noContent().build();
	}

}
