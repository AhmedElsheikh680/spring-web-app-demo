package com.seniorsteps.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.seniorsteps.util.UserModel;

import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */

public class DepartmentDto implements UserModel {
	private static final long serialVersionUID = 1L;


	private int departmentId;

	private String departmentName;

	
	private EmployeeDto employee;

//	private Location location;


	private List<EmployeeDto> employees;

//	private List<JobHistory> jobHistories;
//
//	public Department() {
//	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public EmployeeDto getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

//	public Location getLocation() {
//		return this.location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}

	public List<EmployeeDto> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

	public EmployeeDto addEmployee(EmployeeDto employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public EmployeeDto removeEmployee(EmployeeDto employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

//	public List<JobHistory> getJobHistories() {
//		return this.jobHistories;
//	}
//
//	public void setJobHistories(List<JobHistory> jobHistories) {
//		this.jobHistories = jobHistories;
//	}

//	public JobHistory addJobHistory(JobHistory jobHistory) {
//		getJobHistories().add(jobHistory);
//		jobHistory.setDepartment(this);
//
//		return jobHistory;
//	}
//
//	public JobHistory removeJobHistory(JobHistory jobHistory) {
//		getJobHistories().remove(jobHistory);
//		jobHistory.setDepartment(null);
//
//		return jobHistory;
//	}

//	@Override
//	public String toString() {
//		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employee="
//				+ employee + ", location=" + location + "]";
//	}

}