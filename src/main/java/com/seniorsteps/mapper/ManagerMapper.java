package com.seniorsteps.mapper;

import org.springframework.stereotype.Component;

import com.seniorsteps.dto.EmployeeDto;
import com.seniorsteps.model.Employee;
import com.seniorsteps.util.AbstractModelMapper;

@Component
public class ManagerMapper extends AbstractModelMapper<Employee, EmployeeDto> {

	private static final long serialVersionUID = 1L;

	@Override
	public EmployeeDto convertToDto(Employee employee) {
		EmployeeDto employeeDto = null;

		if (isConvertable(employee)) {
			employeeDto = new EmployeeDto();
			employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setCommissionPct(employee.getCommissionPct());
			employeeDto.setEmail(employee.getEmail());
			employeeDto.setHireDate(employee.getHireDate());
			employeeDto.setPhoneNumber(employee.getPhoneNumber());
			employeeDto.setSalary(employee.getSalary());
		}
		return null;
	}

	@Override
	public Employee convertToEntity(EmployeeDto employeeDto, boolean nullId) {
		Employee employee = null;
		if(isConvertable(employeeDto)) {
			employee = new Employee();
			employee.setEmployeeId(employeeDto.getEmployeeId());
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			employee.setCommissionPct(employeeDto.getCommissionPct());
			employee.setEmail(employeeDto.getEmail());
			employee.setHireDate(employeeDto.getHireDate());
			employee.setPhoneNumber(employeeDto.getPhoneNumber());
			employee.setSalary(employeeDto.getSalary());
		}
		
		
		return null;
	}

}
