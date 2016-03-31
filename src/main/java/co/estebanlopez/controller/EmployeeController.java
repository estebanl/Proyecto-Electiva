package co.estebanlopez.controller;

import co.estebanlopez.domain.Employee;
import co.estebanlopez.domain.Role;
import co.estebanlopez.domain.Supervisor;
import co.estebanlopez.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository repository;

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable long id)
    {
        Employee employee = repository.findOne(id);
        if (employee != null)
        {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST,consumes = "application/json")
    public void newEmployee(@RequestBody Employee employee)
    {
        System.out.println("employee = [" + employee + "]");
        employee.setRole(Role.Employee);
        repository.save(employee);

    }
}
