package com.pws.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "emp_salary", nullable = false)
    private double salary;

    @Column(name = "emp_dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "pin_code", nullable = false)
    private int pinCode;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "emp_email", unique = true, nullable = false)
    private String empEmail;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<EmployeeCompanyXref> employeeCompanyXrefList;

}

