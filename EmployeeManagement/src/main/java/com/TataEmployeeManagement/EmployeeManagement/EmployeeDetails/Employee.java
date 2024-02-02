package com.TataEmployeeManagement.EmployeeManagement.EmployeeDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "Employee_Details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer emp_id;


    @NotNull(message = "Employee name cannot be null")
    @Size(min = 3, max = 50, message = "Employee name must be between 3 and 50 characters")
    @Column(name = "emp_name")
    private String emp_name;

    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "Invalid email format")
    @Column(name = "emp_mail")
    private String emp_email;

    // @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number format. Must be 10 digits.")
    @Column(name = "emp_phno")
    private Long emp_phone;


    public Employee() {
    }

    public Employee(Integer emp_id, String emp_name, String emp_email, Long emp_phone) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.emp_phone = emp_phone;
    }



    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public Long getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(Long emp_phone) {
        this.emp_phone = emp_phone;
    }
}
