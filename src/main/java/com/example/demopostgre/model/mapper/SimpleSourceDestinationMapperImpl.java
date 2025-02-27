package com.example.demopostgre.model.mapper;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import org.springframework.stereotype.Component;

@Component
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

    public EmployeeResponseShortDto sourceShortToDestination(Employee source ){
        if (source == null) {
            return null;
        }

        EmployeeResponseShortDto dto = new EmployeeResponseShortDto();
        dto.setId(source.getId());
        return dto;
    }

}
