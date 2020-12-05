package com.seniorsteps.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seniorsteps.util.UserModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the employees database table.
 * 
 */


public class EmployeeDto implements UserModel {
	private static final long serialVersionUID = 1L;

	private Integer employeeId;


	private BigDecimal commissionPct;

	private String email;

	private String firstName;

	
	private Date hireDate;


	private String lastName;


	private String phoneNumber;

	private BigDecimal salary;


	private List<DepartmentDto> departments;


	private DepartmentDto department;


	private EmployeeDto manager;


	private List<EmployeeDto> employees;

//
//	private Job job;

	public EmployeeDto() {
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<DepartmentDto> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<DepartmentDto> departments) {
		this.departments = departments;
	}

	public DepartmentDto addDepartment(DepartmentDto department) {
		getDepartments().add(department);
		department.setEmployee(this);

		return department;
	}

	public DepartmentDto removeDepartment(DepartmentDto department) {
		getDepartments().remove(department);
		department.setEmployee(null);

		return department;
	}

	public DepartmentDto getDepartment() {
		return this.department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public EmployeeDto getManager() {
		return manager;
	}

	public void setManager(EmployeeDto manager) {
		this.manager = manager;
	}

	public List<EmployeeDto> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

//	public Employee addEmployee(Employee employee) {
//		getEmployees().add(employee);
//		employee.setEmployee(this);
//
//		return employee;
//	}
//
//	public Employee removeEmployee(Employee employee) {
//		getEmployees().remove(employee);
//		employee.setEmployee(null);
//
//		return employee;
//	}

//	public Job getJob() {
//		return this.job;
//	}
//
//	public void setJob(Job job) {
//		this.job = job;
//	}
//
//	public List<JobHistory> getJobHistories() {
//		return this.jobHistories;
//	}
//
//	public void setJobHistories(List<JobHistory> jobHistories) {
//		this.jobHistories = jobHistories;
//	}
//
//	public JobHistory addJobHistory(JobHistory jobHistory) {
//		getJobHistories().add(jobHistory);
//		jobHistory.setEmployee(this);
//
//		return jobHistory;
//	}
//
//	public JobHistory removeJobHistory(JobHistory jobHistory) {
//		getJobHistories().remove(jobHistory);
//		jobHistory.setEmployee(null);
//
//		return jobHistory;
//	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", commissionPct=" + commissionPct + ", email=" + email
				+ ", firstName=" + firstName + ", hireDate=" + hireDate + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + "]";
	}

}