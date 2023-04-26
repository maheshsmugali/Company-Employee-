package com.pws.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cmp_name",nullable = false)
    private String comName;

    @Column(name = "cmp_address",nullable = false)
    private String comAddress;

    @Column(name = "cmp_email",unique = true,nullable = false)
    private String comEmail;

    @Column(name = "pone_no",unique = true,nullable = false)
    private long poneNo;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List< EmployeeCompanyXref> employeeCompanyXrefList;

}