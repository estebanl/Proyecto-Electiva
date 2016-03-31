package co.estebanlopez.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Email(message = "Email invalid")
    @NotEmpty
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "supervisor",cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();

    @ManyToOne()
    @JsonBackReference
    private Manager manager;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
