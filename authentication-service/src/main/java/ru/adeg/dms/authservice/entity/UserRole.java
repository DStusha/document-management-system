package ru.adeg.dms.authservice.entity;

import javax.persistence.*;

@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_role_id;

    @Column
    private Long role_id;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public UserRole() {
    }

    public Long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
