package co.estebanlopez.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email(message = "Email invalid")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne()
    @JsonBackReference
    private Supervisor supervisor;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Hours> hoursList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String email, Role role, Supervisor supervisor) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.supervisor = supervisor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Hours> getHoursList() {
        return hoursList;
    }

    public void setHoursList(List<Hours> hoursList) {
        this.hoursList = hoursList;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
