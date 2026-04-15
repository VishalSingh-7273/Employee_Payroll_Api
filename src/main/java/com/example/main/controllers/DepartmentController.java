package com.example.main.controllers;

import com.example.main.entities.Department;
import com.example.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department add(@RequestBody  Department d){
        return departmentService.add(d);
    }

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable int id,@RequestBody  Department d){
        return departmentService.update(id, d);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
         departmentService.delete(id);
         return "Department deleted successfully";
    }
}
