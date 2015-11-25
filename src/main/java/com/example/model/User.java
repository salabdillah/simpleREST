package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by irsan on 28/9/15.
 */
@Entity
@Table(name = "users", indexes = {
        @Index(columnList = "created_at"), @Index(columnList = "updated_at"),
        @Index(columnList = "creator"), @Index(columnList = "updater")
})
public class User extends EntityBase {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_services",
            joinColumns = { @JoinColumn(name = "username") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    private Set<Service> services;

    public User() {
        super();
        init();
    }

    public User(String username) {
        super(username);
        init();
    }

    private void init() {
        services = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}