package com.example.demopostgre.api;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.model.employeeRequestdto.EmployeeRequestDto;
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

    public EmployeeResponseShortDto getEmployeeWithId(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return modelMapper.map(employee, EmployeeResponseShortDto.class);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void createNewEmployee(EmployeeRequestDto employeeRequestDto) {
        employeeRepository.save(modelMapper.map(employeeRequestDto, Employee.class));
    }

    public void updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee employee = getEmployee(id);
        modelMapper.map(employeeRequestDto, employee);
        employeeRepository.save(employee);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
    }


}
