package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @Column(nullable = false)
    private Long id;
    private String name;
    private String address;

    @ManyToOne
    @NotNull
    @NotEmpty
    private Team team;

    @OneToMany
    private List<Role> roles;
}
