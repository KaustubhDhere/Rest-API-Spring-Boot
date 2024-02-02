package com.TataEmployeeManagement.EmployeeManagement.Controller;

import com.TataEmployeeManagement.EmployeeManagement.EmployeeDetails.Employee;
import com.TataEmployeeManagement.EmployeeManagement.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("{id}")
//    public ResponseEntity<Employee> getEmployeeEntity(@PathVariable Integer id){
//        return ResponseEntity.ok(employeeService.getEmployee(id));
//    }

    @GetMapping(value = "/emp/all")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(this.employeeService.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/emp/get/{id}")
    public ResponseEntity<Employee> getEmp(@PathVariable Integer id) {
        return new ResponseEntity<>(this.employeeService.getEmployee(id),HttpStatus.OK);
    }

    @PostMapping(value = "/emp")
    public ResponseEntity<?> addEmp(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping(value = "/emp/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmp(@PathVariable Integer id,@Valid @RequestBody Employee employee, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.employeeService.updateEmployee(id,employee),HttpStatus.OK);
    }

    @DeleteMapping(value = "/emp/del/{id}")
    public String deleteEmp(@PathVariable Integer id){
         this.employeeService.deleteEmployee(id);
        return "Employee Successfully Deleted";
    }

}
