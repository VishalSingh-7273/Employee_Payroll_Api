package com.example.main.service;

import com.example.main.entities.Payroll;

public interface PayrollService {

    Payroll generate(int empId, Payroll p);

    Payroll getByEmpId(int empId);

    Payroll update(int id, Payroll p);

    void delete(int id);
}