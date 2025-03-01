package com.example.demopostgre.api;

import com.example.demopostgre.domain.Employee;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id")
    public List<EmployeeResponseShortDto> getAllEmployeeWithId() {
        return employeeService.getAllEmployeeWithId();
    }

    @DeleteMapping("/{id}")
    public void deleteByID( @PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }
}
