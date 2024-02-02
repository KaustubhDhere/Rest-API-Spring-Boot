package com.TataEmployeeManagement.EmployeeManagement.Repository;

import com.TataEmployeeManagement.EmployeeManagement.EmployeeDetails.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
}
