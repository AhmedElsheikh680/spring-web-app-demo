package com.seniorsteps.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seniorsteps.dto.EmployeeDto;
import com.seniorsteps.model.Employee;
import com.seniorsteps.util.AbstractModelMapper;

@Component
public class EmployeeMapper extends AbstractModelMapper<Employee, EmployeeDto> {
	
	@Autowired
	private ManagerMapper managerMapper;
	

	@Override
	public EmployeeDto convertToDto(Employee employee) {
		EmployeeDto employeeDto = null;
		if(isConvertable(employee)) {
			employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setCommissionPct(employee.getCommissionPct());
			employeeDto.setEmail(employee.getEmail());
			employeeDto.setHireDate(employee.getHireDate());
			employeeDto.setPhoneNumber(employee.getPhoneNumber());
			employeeDto.setSalary(employee.getSalary());
			employeeDto.setManager(managerMapper.convertToDto(employee.getManager()));
			
			
			
			
		
		}
		return employeeDto;
	}

	@Override
	public Employee convertToEntity(EmployeeDto employeeDto, boolean nullId) {
	
		Employee employee = null;
		if(isConvertable(employeeDto)) {
			employee = new Employee();
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			
		}
		return employee;
		
	}

}
