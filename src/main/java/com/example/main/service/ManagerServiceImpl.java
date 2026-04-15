package com.example.main.service;

import com.example.main.entities.Manager;
import com.example.main.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository repo;

    @Override
    public Manager add(Manager m) {
        return repo.save(m);
    }

    @Override
    public List<Manager> getAll() {
        return repo.findAll();
    }

    @Override
    public Manager update(int id, Manager m) {
        Manager old = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        old.setManagerName(m.getManagerName());
        old.setEmail(m.getEmail());
        old.setMobile(m.getMobile());

        return repo.save(old);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}