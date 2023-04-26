package com.pws.example.repo;

import com.pws.example.entity.Employee;
import com.pws.example.entity.EmployeeCompanyXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeCompanyXrefRepo extends JpaRepository<EmployeeCompanyXref, Integer> {
    @Query("Select e from EmployeeCompanyXref e where e.company.id= :id")
        public List<EmployeeCompanyXref> findEmpCmpById(Integer id);

}

