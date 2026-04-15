package com.example.main.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payrollId;

    @Positive
    private double basicSalary;
    private double hrs;
    private double bonus;
    private double deductions;
    private double netSalary;

    @OneToOne
    @JoinColumn(name="empId")
    private Employee employee;

}
