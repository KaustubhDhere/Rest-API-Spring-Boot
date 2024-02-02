package com.TataEmployeeManagement.EmployeeManagement.Services;

import com.TataEmployeeManagement.EmployeeManagement.EmployeeDetails.Employee;
import com.TataEmployeeManagement.EmployeeManagement.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeesRepository employeesRepository;


    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }


    //    For All Employee
    public List<Employee> getAll() {
        return this.employeesRepository.findAll();
    }

    //For Particular Employee
    public Employee getEmployee(Integer id) {
        return employeesRepository.findById(id).get();
    }

    //    For Add Employee
    public Employee addEmployee(Employee employee) {
        return this.employeesRepository.save(employee);
    }

    //For Update the Employee
    public Employee updateEmployee(Integer id, Employee employee) {

        Optional<Employee> emp = this.employeesRepository.findById(id);

        if (emp.isPresent()) {
            emp.get().setEmp_name(employee.getEmp_name());
            emp.get().setEmp_email(employee.getEmp_email());
            emp.get().setEmp_phone(employee.getEmp_phone());
            return this.employeesRepository.save(emp.get());
        }
        throw new RuntimeException();
    }

    //For delete the Employee
    public void deleteEmployee(Integer id) {
        this.employeesRepository.deleteById(id);
    }

}
