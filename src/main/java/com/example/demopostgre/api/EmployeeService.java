package com.example.demopostgre.api;

import com.example.demopostgre.repository.EmployeeRepository;
import com.example.demopostgre.response.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.response.mapper.SimpleSourceDestinationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SimpleSourceDestinationMapper simpleSourceDestinationMapper;

    public EmployeeService(EmployeeRepository employeeRepository, SimpleSourceDestinationMapper simpleSourceDestinationMapper) {
        this.employeeRepository = employeeRepository;
        this.simpleSourceDestinationMapper = simpleSourceDestinationMapper;
    }

    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(simpleSourceDestinationMapper::sourceToDestination)
                .toList();
    }
}
