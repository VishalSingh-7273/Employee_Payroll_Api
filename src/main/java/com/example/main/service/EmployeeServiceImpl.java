package com.example.main.service;

import com.example.main.entities.Employee;
import com.example.main.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee add(Employee e) {
        return repo.save(e);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee update(int id, Employee newEmp) {
        Employee e = get(id);
        e.setEmpName(newEmp.getEmpName());
        e.setEmail(newEmp.getEmail());
        e.setMobile(newEmp.getMobile());
        return repo.save(e);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}