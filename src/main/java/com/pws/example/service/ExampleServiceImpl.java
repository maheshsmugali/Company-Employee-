package com.pws.example.service;

import com.pws.example.entity.Company;
import com.pws.example.entity.Employee;
import com.pws.example.entity.EmployeeCompanyXref;
import com.pws.example.exception.ExampleException;
import com.pws.example.repo.CompanyRepository;
import com.pws.example.repo.EmployeeCompanyXrefRepo;
import com.pws.example.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeCompanyXrefRepo employeeCompanyXrefRepo;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) throws ExampleException {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser;
        }
        throw new ExampleException("Id Not Present");
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> getCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void comanyEmployeeMapping(Company company, List<Employee> employeeList) {
        employeeList.stream().forEach(
                employee -> {
                    EmployeeCompanyXref employeeCompanyXref = EmployeeCompanyXref.builder().employee(employee).company(company).build();
                    employeeCompanyXrefRepo.save(employeeCompanyXref);
                }
        );
    }

    @Override
    public List<Employee> getEmployeeAsc() {
        return employeeRepository.findEmployeeWitAscEmpName();
    }

    @Override
    public List<Employee> getEmpPattern(String ch) {
        return employeeRepository.findEmployeePattern(ch);
    }

    @Override
    public int fetcEmpCmpByCmpId(Integer id) {
        List<EmployeeCompanyXref> emplyeeList = employeeCompanyXrefRepo.findEmpCmpById(id);
        return emplyeeList.size();
    }

    @Override
    public List<Employee> fetcEmpbyMont(int date) {
        return employeeRepository.findEmployeeDob(date);
    }

    public List<Employee> findEmpByNthHighestSalary(int n) {
        Pageable pageable = PageRequest.of(n - 1, 1, Sort.by("salary").descending());
        return employeeRepository.findEmpByNthHighestSalary(pageable);
    }

}

