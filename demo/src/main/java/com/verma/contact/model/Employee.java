package com.verma.contact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@NotEmpty(message = "FirstName may not be null")
	private String firstName;

	@NotEmpty(message = "LastName may not be null")
	private String lastName;

	@NotEmpty(message = "EmailAddress may not be null")
	private String emailAddress;

}
