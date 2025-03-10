package com.example.demopostgre.api;

import com.example.demopostgre.domain.Address;
import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.model.employeeRequestdto.EmployeeRequestDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import com.example.demopostgre.repository.AddressRepository;
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
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                .toList();
    }

    public EmployeeResponseShortDto getEmployeeWithId(Long id) {
        return modelMapper.map(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found")), EmployeeResponseShortDto.class);
    }

    public void addAddress(Long employeeId, String address) {
        Employee employee = getEmployee(employeeId);

        Address address2 = new Address();
        address2.setAddress(address);

        address2.setEmployee(employee);
        addressRepository.save(address2);
    }


    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void createNewEmployee(EmployeeRequestDto employeeRequestDto) {
        employeeRepository.save(modelMapper.map(employeeRequestDto, Employee.class));
    }

    public void updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee employee = getEmployee(id);
//        employee = employee.builder().id(id).name(employeeRequestDto.getName())
//                .surname(employeeRequestDto.getSurname()).salary(employeeRequestDto.getSalary()).build();
        modelMapper.map(employeeRequestDto, employee);
        employeeRepository.save(employee);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }


}
