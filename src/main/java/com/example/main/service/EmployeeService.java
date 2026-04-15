package com.example.main.service;

import com.example.main.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee e);

    List<Employee> getAll();

    Employee get(int id);

    Employee update(int id, Employee e);

    void delete(int id);
}
