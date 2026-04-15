package com.example.main.service;

import com.example.main.entities.Employee;
import com.example.main.entities.Payroll;
import com.example.main.repositories.EmployeeRepository;
import com.example.main.repositories.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Payroll generate(int empId, Payroll p) {
        Employee emp=employeeRepository.findById(empId).orElse(null);

        double net=p.getBasicSalary()
                + p.getHrs()
                + p.getBonus() -
                p.getDeductions();

        p.setNetSalary(net);
        p.setEmployee(emp);



        return  payrollRepository.save(p);
    }

    @Override
    public Payroll getByEmpId(int empId) {
        return payrollRepository.findById(empId).orElse(null);

    }

    @Override
    public Payroll update(int id, Payroll p) {

        Payroll old = payrollRepository.findById(id).orElse(null);

        old.setBasicSalary(p.getBasicSalary());
        old.setHrs(p.getHrs());
        old.setBonus(p.getBonus());
        old.setDeductions(p.getDeductions());

        return payrollRepository.save(old);
    }

    @Override
    public void delete(int id) {
        payrollRepository.deleteById(id);
    }
}
