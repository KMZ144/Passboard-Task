package com.global.computers.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.global.computers.base.entity.BaseEntity;
import com.global.computers.base.repo.BaseRepo;



public class BaseService <E extends BaseEntity<ID>,ID extends Number> {
	
	@Autowired
	private BaseRepo<E, ID> baseRepo;
	
	public List<E> findAll(){
		return baseRepo.findAll();
	}
	
	public E findById(ID id){
		return baseRepo.findById(id).orElseThrow();
	}
	
	public E insert(E entity){
		return baseRepo.save(entity);
	}
	
	public E update(ID id, E entity){
		 findById(id);
		return baseRepo.save(entity);
	}
	
	public void delete(ID id){
		findById(id);
		baseRepo.deleteById(id);
	}
	
}
