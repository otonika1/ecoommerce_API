package com.example.practice.controller;

import com.example.practice.entity.EmployeeEntity;
import com.example.practice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeEntity>findAllEmployee(){
        return employeeService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }
    @PostMapping
    public EmployeeEntity postEmployee(@RequestBody EmployeeEntity employeeEntity){
        return  employeeService.saveEmployee(employeeEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
