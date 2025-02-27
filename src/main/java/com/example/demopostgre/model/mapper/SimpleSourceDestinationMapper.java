package com.example.demopostgre.model.mapper;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public interface SimpleSourceDestinationMapper {

    EmployeeResponseDto sourceToDestination(Employee source);

    EmployeeResponseShortDto sourceShortToDestination(Employee source);

}
