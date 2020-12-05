package com.seniorsteps.mapper;

import org.springframework.stereotype.Component;

import com.seniorsteps.dto.DepartmentDto;
import com.seniorsteps.model.Department;
import com.seniorsteps.util.AbstractModelMapper;

@Component
public class DepartmentMapper extends AbstractModelMapper<Department, DepartmentDto> {

	@Override
	public DepartmentDto convertToDto(Department e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department convertToEntity(DepartmentDto d, boolean nullId) {
		// TODO Auto-generated method stub
		return null;
	}

}
