package com.example.main.service;

import com.example.main.entities.Department;

import java.util.List;

public interface DepartmentService {

    Department add(Department d);

    List<Department> getAll();

    Department update(int id, Department d);

    void delete(int id);
}