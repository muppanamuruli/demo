package com.verma.contact.service;

import java.util.Optional;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verma.contact.dao.EmployeeEntityDao;
import com.verma.contact.exception.EmailValidationException;
import com.verma.contact.exception.EmployeeNotfoundException;
import com.verma.contact.model.Employee;

@Service
public class ContactServiceImpl {

	@Autowired
	EmployeeEntityDao employeeEntityDao;

	public void createContact(Employee e) {

		EmailValidator validator = EmailValidator.getInstance();

		if (!validator.isValid(e.getEmailAddress()))
			throw new EmailValidationException();

		employeeEntityDao.save(e);

	}

	public void updateContact(Employee e, int id) {
		if (!employeeEntityDao.existsById(id))
			throw new EmployeeNotfoundException();

		employeeEntityDao.updateEmployeeById(e.getFirstName(), e.getLastName(), e.getEmailAddress(), e.getId());

	}

	public void deleteContact(int id) {
		if (!employeeEntityDao.existsById(id))
			throw new EmployeeNotfoundException();

		employeeEntityDao.deleteById(id);

	}

	public Employee getContact(int id) {
		if (!employeeEntityDao.existsById(id))
			throw new EmployeeNotfoundException();

		Optional<Employee> emp = employeeEntityDao.findById(id);
		return emp.get();

	}

}
