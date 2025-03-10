package com.example.demopostgre.model.employeeResponseDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeResponseDto {

    private Long id;
    private String name;
    private String surname;
    private double salary;
    private List<AddressResponseDto> address;

}
