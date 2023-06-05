package com.global.computers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import com.global.computers.entity.Computer;
import com.global.computers.service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {
	
	@Autowired
	private ComputerService computerService;
	
	@GetMapping("")
	public ResponseEntity<List<Computer>> findAll(){
		return ResponseEntity.ok(computerService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Computer> findById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(computerService.findById(id));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<List<Computer>> findByEmployeeId(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(computerService.findComputersByEmpId(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Computer> insertComputer(@RequestBody Computer computer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(computerService.insert(computer));
	}
	
	@PatchMapping("{compId}/employees/{empId}")
	public ResponseEntity<?> addComputerToEmployee(@PathVariable long compId,@PathVariable long empId){
		if (computerService.checkComputersAssignedToEmp(empId)) {
			return ResponseEntity.ok(Map.of("data", computerService.addComputerToEmployee(compId, empId)
					,"message","computers assigned to this employee excceds 3"));
		}
		return ResponseEntity.ok(computerService.addComputerToEmployee(compId, empId));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComputer(@PathVariable long id) {
		 computerService.delete(id);
		 return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
}
