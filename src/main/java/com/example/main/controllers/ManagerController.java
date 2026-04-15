package com.example.main.controllers;

import com.example.main.entities.Manager;
import com.example.main.service.EmployeeService;
import com.example.main.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public Manager add(@RequestBody Manager m){
        return managerService.add(m);
    }

    @GetMapping
    public List<Manager> getAll(){
        return managerService.getAll();
    }

    @PutMapping("/{id}")
    public Manager update(@PathVariable int id,@RequestBody Manager m){
        return  managerService.update(id,m);
    }

    public String delete(@PathVariable int id){
        managerService.delete(id);
        return "Manager deleted successfully";
    }

}
