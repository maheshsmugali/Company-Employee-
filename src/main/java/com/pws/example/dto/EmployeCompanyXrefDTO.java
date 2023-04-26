package com.pws.example.dto;

import com.pws.example.entity.Company;
import com.pws.example.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeCompanyXrefDTO {

    private Employee employee;

    private Company company;

}
