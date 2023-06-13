package com.example.practice.services;

import com.example.practice.entity.EmployeeEntity;
import com.example.practice.repository.CarouselRepository;
import com.example.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final CarouselRepository carouselRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CarouselRepository carouselRepository) {
        this.employeeRepository = employeeRepository;
        this.carouselRepository = carouselRepository;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    //@Transactional
    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
//        CarouselEntity carousel = employeeRepository.getById(carouselRepository.);
//
//        employee.setDepartment(department);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
