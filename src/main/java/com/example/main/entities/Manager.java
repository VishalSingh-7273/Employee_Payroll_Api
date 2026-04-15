package com.example.main.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;
    @NotBlank
    private String managerName;
    @Email
    private String email;
    @Pattern(regexp = "\\d{10}")
    private String mobile;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
}
