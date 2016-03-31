package co.estebanlopez.controller;

import co.estebanlopez.domain.*;
import co.estebanlopez.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class ManagerController {

    private ManagerRepository repository;

    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository) {
        this.repository = managerRepository;
    }

    @RequestMapping(value = "/manager/{id}",method = RequestMethod.GET)
    public ResponseEntity<Manager> getManager(@PathVariable long id)
    {
        Manager manager = repository.findOne(id);
        if (manager != null)
        {
            return ResponseEntity.ok(manager);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @RequestMapping(value = "/manager",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody @Valid Manager manager, BindingResult result){

        if (result.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result.getAllErrors());
        }
        Manager validManager = repository.findByEmail(manager.getEmail());

        if ((repository.findByEmail(manager.getEmail())) != null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).header("Email is used").body(manager.getEmail());
        }
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String resultEncoder = passwordEncoder.encodePassword(manager.getPassword(),null);
        manager.setPassword(resultEncoder);
        manager.setRole(Role.Manager);
        return ResponseEntity.ok().body(repository.save(manager));
    }

    @RequestMapping(value = "/manager",method = RequestMethod.PUT,consumes = "application/json")
    public void update(@RequestBody Manager manager){
        repository.save(manager);
    }
}
