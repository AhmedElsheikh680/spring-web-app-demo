package com.seniorsteps.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seniorsteps.util.DomainModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name = "employees")
@NamedEntityGraphs({
@NamedEntityGraph(name="Employee.simple", attributeNodes = {
		@NamedAttributeNode(value="department", subgraph = "withLocation"),
		@NamedAttributeNode("job")
}, subgraphs= {
		@NamedSubgraph(name="withLocation", attributeNodes = {
				@NamedAttributeNode("location")
		})
}),
@NamedEntityGraph(name="Employee.basic", attributeNodes = {
		@NamedAttributeNode(value="department", subgraph = "withLocation")
}, subgraphs= {
		@NamedSubgraph(name="withLocation", attributeNodes = {
				@NamedAttributeNode("location")
		})
})
})

public class Employee implements DomainModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "commission_pct")
	private BigDecimal commissionPct;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	private BigDecimal salary;

	// bi-directional many-to-one association to Department
	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Department> departments;

	// bi-directional many-to-one association to Department
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	// bi-directional many-to-one association to Employee
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Employee manager;

	// bi-directional many-to-one association to Employee
//	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private List<Employee> employees;

	// bi-directional many-to-one association to Job
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	private Job job;

	// bi-directional many-to-one association to JobHistory
//	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistories;

	public Employee() {
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

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setEmployee(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setEmployee(null);

		return department;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
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

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setEmployee(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setEmployee(null);

		return jobHistory;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", commissionPct=" + commissionPct + ", email=" + email
				+ ", firstName=" + firstName + ", hireDate=" + hireDate + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + "]";
	}

}