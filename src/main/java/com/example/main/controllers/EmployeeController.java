package com.example.main.controllers;

import com.example.main.entities.Employee;
import com.example.main.repositories.EmployeeRepository;
import com.example.main.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee>add (@Valid @RequestBody Employee e){
        return ResponseEntity.ok(employeeService.add(e));
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public  Employee get(@PathVariable int id){
        return employeeService.get(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @Valid @RequestBody Employee e){
        return employeeService.update(id, e);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Employee deleted successfully";
    }
}
