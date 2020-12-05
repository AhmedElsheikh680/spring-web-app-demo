package com.seniorsteps.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.dao.DepartmentDao;
import com.seniorsteps.dao.EmployeeDao;
import com.seniorsteps.model.Employee;
import com.seniorsteps.search.EmployeeCriteria;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmps() {
		List<Employee> emps = employeeDao.findAll();
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> list(){
		List<Employee> emps = employeeDao.findAll(Sort.by("firstName").descending());
		if(emps != null) {
			return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);

		}
		return null;
	}
	
	//Example.of
	@GetMapping("allByFNameLNAme")
	public ResponseEntity<List<Employee>> allByFNameLNAme(){
		Employee employee = new Employee();
		employee.setFirstName("AAAAAA");
		employee.setLastName("ssssssssssssssssssss");
		List<Employee> emps =  employeeDao.findAll(Example.of(employee));
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	// Specification 
//	@GetMapping("/allUsingSpecification")
//	public ResponseEntity<List<Employee>> allUsingSpecification(EmployeeCriteria criteria){
//		List<Employee> emps = employeeDao.findAll(criteria);
//		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
//	}
	@GetMapping("/allUsingSpecification")
	public List<Employee> allUsingSpecification(EmployeeCriteria criteria){
		return employeeDao.findAll(criteria);
		
	}
	
	@GetMapping("/allEmps")
	public ResponseEntity<Page<Employee>> all(){
//		Page<Employee> emps = employeeDao.findAll(PageRequest.of(0,5));
		Page<Employee> emps = employeeDao.findAll(PageRequest.of(0,5,Sort.by("firstName").descending()));
		return new ResponseEntity<Page<Employee>>(emps, HttpStatus.OK);
	}
	

	@GetMapping("/getByFirstname")
	
	public ResponseEntity<List<Employee>> getByFName(@RequestParam("firstName") String firstName) {
		List<Employee> emps = employeeDao.getAllEmpByFirstName(firstName);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Integer id) {

		Employee emp = employeeDao.findById(id).get();
		if (emp != null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp) {

		emp = employeeDao.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
		emp = employeeDao.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable Integer id) {
		employeeDao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmpWithDept/{departmentId}")
	@Transactional
	public ResponseEntity<Void> deleteEmpWithDept(@PathVariable("departmentId") int departmentId) {
		employeeDao.deleteByDepartmentDepartmentId(departmentId);
		departmentDao.deleteById(departmentId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
