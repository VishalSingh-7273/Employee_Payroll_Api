package com.example.main.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @NotBlank
    private String empName;
    @Email
    private String email;
    @Pattern(regexp = "\\d{10}")
    private String mobile;
    private LocalDate dateOfJoining;

    @ManyToOne
    @JoinColumn(name="departmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name="managerId")
    private Manager manager;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Payroll payroll;

}
