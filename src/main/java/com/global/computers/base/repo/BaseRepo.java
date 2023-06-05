package com.global.computers.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.global.computers.base.entity.BaseEntity;


@NoRepositoryBean
public interface BaseRepo<T extends BaseEntity<ID> ,ID extends Number> extends JpaRepository<T, ID> {
	

}
