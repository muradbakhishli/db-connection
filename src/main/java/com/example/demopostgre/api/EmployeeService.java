package com.example.demopostgre.api;

import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import com.example.demopostgre.repository.EmployeeRepository;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .toList();
    }

    public List<EmployeeResponseShortDto> getAllEmployeeWithId(long id) {
        return employeeRepository.findById(id)
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseShortDto.class))
                .toList();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
