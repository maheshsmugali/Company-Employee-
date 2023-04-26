package com.pws.example.controller;

import com.pws.example.entity.Company;
import com.pws.example.entity.Employee;
import com.pws.example.exception.ExampleException;
import com.pws.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/public")
@RestController
public class ExampleController {

    @Autowired
    private ExampleService service;

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) throws ExampleException {
        service.addEmployee(employee);
    }

    @GetMapping("/get/employee")
    public List<Employee> getEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/get/id")
    public void deleteEmployee(@RequestParam int id) {
        service.deleteEmployee(id);
    }

    @PostMapping("/company")
    public void addCompany(@RequestBody Company company) throws ExampleException {
        service.addCompany(company);
    }

    @GetMapping("/get/company")
    public List<Company> getCompany() {
        return service.getCompany();
    }

    @PostMapping("/employeCompanyXref")
    public void employeCompanyXref(@RequestBody Company company, @RequestParam List<Employee> employeeList) {
        service.comanyEmployeeMapping(company, employeeList);
    }

    @GetMapping("/asc")
    public List<Employee> findEmployeeAsc() {
        return service.getEmployeeAsc();
    }

    @GetMapping("/char")
    public List<Employee> fetchByPattern(@RequestParam String ch) throws ExampleException {
        return service.getEmpPattern(ch);
    }

    @GetMapping("/id")
    public Integer fetchEmpByCmpId(@RequestParam Integer id) throws ExampleException {
        return service.fetcEmpCmpByCmpId(id);
    }

    @GetMapping("/date")
    public List<Employee> fetchEmpByDate(@RequestParam int date) throws ExampleException {
        return service.fetcEmpbyMont(date);
    }

    @GetMapping("/salary")
    public List<Employee> getEmpByNthHighestSalary(@RequestParam int n) {
        return service.findEmpByNthHighestSalary(n);
    }

}














