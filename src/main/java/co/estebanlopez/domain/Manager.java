package co.estebanlopez.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @Email(message = "Email invalid")
    @NotEmpty(message = "Value empty")
    private String email;

    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Supervisor> supervisors  = new ArrayList<>();

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
