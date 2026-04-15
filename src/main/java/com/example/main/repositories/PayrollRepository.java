package com.example.main.repositories;

import com.example.main.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}
