package com.seniorsteps.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.seniorsteps.model.Employee;

public class EmployeeCriteria implements Specification<Employee> {

	private String firstName;
	private String lastName;
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
	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	
		Predicate predicate = criteriaBuilder.and(criteriaBuilder.like(root.get("firstName"), "%" + this.firstName + "%"),
				criteriaBuilder.like(root.get("lastName"), "%" + this.lastName + "%"));
		return predicate;
	}
	
}
