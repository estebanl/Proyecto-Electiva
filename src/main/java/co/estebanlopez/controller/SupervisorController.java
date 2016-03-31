package co.estebanlopez.controller;

import co.estebanlopez.domain.*;
import co.estebanlopez.repository.ManagerRepository;
import co.estebanlopez.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@RestController
public class SupervisorController {

    private SupervisorRepository repository;
    @Autowired
    public void setRepository(SupervisorRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/supervisor/{id}",method = RequestMethod.GET)
    public ResponseEntity<Supervisor> getOne(@PathVariable long id)
    {
        Supervisor supervisor = repository.findOne(id);
        if (supervisor != null)
        {
            return ResponseEntity.ok(supervisor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }



    @RequestMapping(value = "/supervisor",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody @Valid Supervisor supervisor, BindingResult result){

        if (result.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result.getAllErrors());
        }
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String passwordResult = passwordEncoder.encodePassword(supervisor.getPassword(),null);
        supervisor.setPassword(passwordResult);
        supervisor.setRole(Role.Supervisor);
        return ResponseEntity.ok().body(repository.save(supervisor));
    }

    @RequestMapping(value = "/supervisor",method = RequestMethod.PUT, consumes = "application/json")
    public void update(@RequestBody Supervisor supervisor)
    {
        Supervisor supervisor1 = repository.findOne(supervisor.getId());
        supervisor1.getEmployees().add(supervisor.getEmployees().get(supervisor.getEmployees().size()-1));

        System.out.println("supervisor = [" + supervisor + "]");
        repository.save(supervisor1);
    }
}
