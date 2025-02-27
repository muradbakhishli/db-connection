package com.example.demopostgre.response.employeeResponseDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class EmployeeResponseDto {

    private Long id;
    private String name;
    private String surname;
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
