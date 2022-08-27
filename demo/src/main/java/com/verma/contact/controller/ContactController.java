package com.verma.contact.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verma.contact.model.Employee;
import com.verma.contact.service.ContactServiceImpl;

@RestController
@RequestMapping(value="employee")
public class ContactController {
	
	Logger logger = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	ContactServiceImpl contactServiceImpl;
	
	
    /*
     * Create Contact details of Employee
     */
	@RequestMapping(value = "/createContact", method = RequestMethod.POST)
	public void createContact(@RequestBody @Valid Employee emp) throws EnumConstantNotPresentException {
		logger.debug("Enter createContact:",emp.toString());
		contactServiceImpl.createContact(emp);

	}

	/*
     * update Contact details of Employee
     */
	@RequestMapping(value = "/updatecontact/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateContact(@PathVariable("id") int id, @RequestBody @Valid Employee emp) {
		contactServiceImpl.updateContact(emp, id);

		return ResponseEntity.accepted().body("Empoyee with ID:" + id + " updated succesfull");

	}

	/*
     * delete Contact details of Employee
     */
	@RequestMapping(value = "/deletecontact/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteContact(@PathVariable("id") int id) {
		contactServiceImpl.deleteContact(id);
		return ResponseEntity.accepted().body("Empoyee with ID:" + id + " deleted succesfull");

	}

	/*
     * get Contact details of Employee
     */
	@RequestMapping(value = "/getcontact/{id}", method = RequestMethod.GET)
	public ResponseEntity getContact(@PathVariable("id") int id) {

		Employee emp = contactServiceImpl.getContact(id);
		return ResponseEntity.accepted().body(emp);

	}

}
