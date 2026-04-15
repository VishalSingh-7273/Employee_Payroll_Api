package com.example.main.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    @NotBlank
    private String departmentName;
    @NotBlank
    private String location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
