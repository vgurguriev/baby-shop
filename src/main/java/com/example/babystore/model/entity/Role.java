package com.example.babystore.model.entity;

import com.example.babystore.model.entity.enums.UserRolesEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private UserRolesEnum role;

    @ManyToMany(mappedBy = "role")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public Role setRole(UserRolesEnum role) {
        this.role = role;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
