package com.pws.example.repo;

import com.pws.example.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e from Employee e order by LENGTH(e.empName), e.empName ASC")
    public List<Employee> findEmployeeWitAscEmpName();

    @Query("Select e from Employee e where e.empName like :ch%")
    public List<Employee> findEmployeePattern(String ch);

    @Query("Select e from Employee e where MONTH(e.dob) = :date")
    public List<Employee> findEmployeeDob(int date);

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> findEmpByNthHighestSalary(Pageable pageable);

}
