package com.verma.contact.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verma.contact.model.Employee;

@Repository
public interface EmployeeEntityDao extends CrudRepository<Employee, Integer> {

	@Modifying
	@Transactional 
	@Query("update Employee emp set emp.firstName = ?1, emp.lastName = ?2, emp.emailAddress = ?3 where emp.id = ?4")
	void updateEmployeeById(String firstname, String lastname, String emailAddress, int id);

}
