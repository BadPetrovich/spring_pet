package com.badpetrovich.spring.spring_pet.dao;

import com.badpetrovich.spring.spring_pet.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByName(String name);

}
