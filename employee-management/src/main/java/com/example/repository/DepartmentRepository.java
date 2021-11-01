package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Department;

@Repository
public class DepartmentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public Department load(Integer id) {
		System.out.println("Repositoryのload()が呼ばれました");
		return null;
	}
	
	public List<Department> findAll(){
		System.out.println("RepositoryのfindAll()が呼ばれました");
		return new ArrayList<Department>();
	}
	
	public Department save(Department department) {
		System.out.println("Repositoryのsave()が呼ばれました");
		return null;
	}
	
	public void deleteById(Integer id) {
		System.out.println("RepositoryのdeleteById()が呼ばれました");
	}
}
