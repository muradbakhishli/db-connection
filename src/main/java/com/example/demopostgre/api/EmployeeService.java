package com.example.demopostgre.api;

import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import com.example.demopostgre.repository.EmployeeRepository;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.model.mapper.SimpleSourceDestinationMapper;
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

    public List<EmployeeResponseShortDto> getAllEmployeeWithId() {
        return employeeRepository.findAll()
                .stream()
                .map(simpleSourceDestinationMapper::sourceShortToDestination)
                .toList();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
