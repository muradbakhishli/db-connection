package com.example.demopostgre.api;

import com.example.demopostgre.model.employeeRequestdto.EmployeeRequestDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseDto;
import com.example.demopostgre.model.employeeResponseDto.EmployeeResponseShortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseShortDto getEmployeeWithId(@PathVariable Long id) {
        return employeeService.getEmployeeWithId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.createNewEmployee(employeeRequestDto);
    }


    @PostMapping("/add-address")
    public void addAddress(@RequestParam Long employeeId, @RequestParam String address){
        employeeService.addAddress(employeeId, address);
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.updateEmployee(id, employeeRequestDto);
    }

}
