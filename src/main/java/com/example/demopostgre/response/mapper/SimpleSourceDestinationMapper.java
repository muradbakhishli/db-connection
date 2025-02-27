package com.example.demopostgre.response.mapper;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.response.employeeResponseDto.EmployeeResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SimpleSourceDestinationMapper {

    EmployeeResponseDto sourceToDestination(Employee source);

}
