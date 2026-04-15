package com.example.main.service;

import com.example.main.entities.Department;
import com.example.main.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    @Override
    public Department add(Department d) {
        return repo.save(d);
    }

    @Override
    public List<Department> getAll() {
        return repo.findAll();
    }

    @Override
    public Department update(int id, Department d) {
        Department old = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        old.setDepartmentName(d.getDepartmentName());
        old.setLocation(d.getLocation());

        return repo.save(old);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}