package com.example.demopostgre.response.mapper;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.response.employeeResponseDto.EmployeeResponseDto;

public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {


    @Override
    public EmployeeResponseDto sourceToDestination(Employee source) {
        if (source == null) {
            return null;
        }

        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setSurname(source.getSurname());
        dto.setSalary(source.getSalary());
        return dto;
    }

}
