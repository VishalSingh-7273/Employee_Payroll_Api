package com.example.main.service;

import com.example.main.entities.Manager;

import java.util.List;

public interface ManagerService {

    Manager add(Manager m);

    List<Manager> getAll();

    Manager update(int id, Manager m);

    void delete(int id);
}