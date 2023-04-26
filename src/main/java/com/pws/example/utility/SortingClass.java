package com.pws.example.utility;

import com.pws.example.entity.Employee;

import java.util.Comparator;

public class SortingClass implements Comparator <Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return (int)(e1.getSalary() - e2.getSalary());
    }
}
