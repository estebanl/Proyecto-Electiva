package co.estebanlopez.controller;

import co.estebanlopez.domain.Manager;
import co.estebanlopez.domain.Supervisor;
import co.estebanlopez.repository.ManagerRepository;
import co.estebanlopez.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private ManagerRepository managerRepository;
    private SupervisorRepository supervisorRepository;

    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Autowired
    public void setSupervisorRepository(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> manager(@RequestBody Manager manager) {

        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String passwordResult = passwordEncoder.encodePassword(manager.getPassword(),null);

        Manager manager1 = managerRepository.findByEmailAndPassword(manager.getEmail(), passwordResult);
        if (manager1 != null)
        {
            return ResponseEntity.ok(manager1);
        }
            Supervisor supervisor = supervisorRepository.findByEmailAndPassword(manager.getEmail(),passwordResult);
            if (supervisor != null)
            {
                return ResponseEntity.ok(supervisor);
            }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
