package com.bangsms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="firstname", length=50)
	private String firstName;
	
	@Column(name="lastname", length=50)
	private String lastName;
	
	@Column(name="designation", length=20)
	private String designation;
	
	@Column(name="salary")
	private Integer salary;
	
	public Employee() {
	}

	public Employee(Long id) {
		this.id = id;
	}

	public Employee(Long id, String firstname, String lastname, String designation, Integer salary) {
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee(String firstname, String lastname, String designation, Integer salary) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", firstName: ").append(this.firstName).append(", lastName: ")
				.append(this.lastName).append(", Designation: ").append(this.designation).append(", Salary: ")
				.append(this.salary);
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Employee toCompare = (Employee) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	
	

}
