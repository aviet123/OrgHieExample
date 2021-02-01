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
    @JoinColumn(name = "team_id",nullable = false)
    private Team team;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Role> roles;
}
