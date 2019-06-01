package ru.adeg.dms.uservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "user_id", orphanRemoval = true, cascade={CascadeType.REMOVE, CascadeType.MERGE})
    private Set<UserRole> roles = new HashSet<UserRole>();

    public User() { }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
