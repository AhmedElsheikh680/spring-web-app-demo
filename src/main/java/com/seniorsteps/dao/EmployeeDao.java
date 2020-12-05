package com.seniorsteps.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seniorsteps.model.Employee;

@Repository
public interface EmployeeDao extends JpaSpecificationExecutor<Employee> ,JpaRepository<Employee, Integer> {
	
	@Query("from Employee e where e.firstName= :firstName")
	@EntityGraph(value="Employee.simple", type = EntityGraphType.FETCH)
	public List<Employee> getAllEmpByFirstName(@Param("firstName")String firstName);
	
	@Override
	@EntityGraph(value="Employee.simple", type = EntityGraphType.FETCH)
	Optional<Employee> findById(Integer id);
	
	@Modifying
	public void deleteByDepartmentDepartmentId(int departmentId);
	
	
}
