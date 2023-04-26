package com.pws.example.service;

import com.pws.example.entity.Company;
import com.pws.example.entity.Employee;
import com.pws.example.exception.ExampleException;

import java.util.List;
import java.util.Optional;


public interface ExampleService {
    void addEmployee(Employee employee);

    List<Employee> getEmployee();

    Optional<Employee> getEmployeeById(int id) throws ExampleException;

    void deleteEmployee(int id);

    void addCompany(Company company);

    List<Company> getCompany();

    void comanyEmployeeMapping(Company company, List<Employee> employeeList);

    List<Employee> getEmployeeAsc();

    List<Employee> getEmpPattern(String ch);

    int fetcEmpCmpByCmpId(Integer id);

    List<Employee> fetcEmpbyMont(int date);

    List<Employee> findEmpByNthHighestSalary(int n);
}
