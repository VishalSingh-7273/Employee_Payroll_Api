package com.example.main.controllers;

import com.example.main.entities.Payroll;
import com.example.main.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/{empId}")
    public Payroll generate(@PathVariable int empId, @RequestBody Payroll p ){
        return payrollService.generate(empId,p);
    }

    @GetMapping("/{empId}")
    public Payroll get(@PathVariable int empId){
        return payrollService.getByEmpId(empId);
    }

    @PutMapping("/{id}")
    public Payroll update(@PathVariable int id, Payroll p){
        return payrollService.update(id,p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        payrollService.delete(id);
        return "Payroll Deleted Successfully";
    }
}
